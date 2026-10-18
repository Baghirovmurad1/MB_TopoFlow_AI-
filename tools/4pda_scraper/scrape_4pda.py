#!/usr/bin/env python3
"""Скрапер темы форума 4PDA: собирает все сообщения (модули) со всех страниц.

Пример:
    python3 scrape_4pda.py --topic 603033 --pages 89 --out output/topic_603033

Только стандартная библиотека. Каждая скачанная страница кэшируется в
<out>/cache, поэтому повторный запуск докачает только то, чего нет.

Результат:
    <out>/posts.jsonl  — по одной записи на сообщение (для обработки программой)
    <out>/modules.md   — читаемый список: заголовок, описание, ссылки
"""
import argparse
import hashlib
import json
import os
import re
import sys
import time
import urllib.error
import urllib.parse
import urllib.request
from html.parser import HTMLParser

BASE_URL = "https://4pda.to/forum/index.php"
USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) 4pda-topic-scraper/1.0"
PER_PAGE = 20  # сообщений на странице темы (стандарт IPB); меняется --per-page

# CSS-классы блоков сообщения. Разметка 4PDA может меняться: если на странице
# не находится ни одного сообщения, скрипт напишет предупреждение, а сырой HTML
# лежит в <out>/cache — по нему нужно поправить эти множества.
POST_CLASSES = {"post_block", "post_wrap"}     # контейнер одного сообщения
AUTHOR_CLASSES = {"author", "postuser", "pnick", "post-user"}
DATE_CLASSES = {"postdetails", "post-date", "pdate"}
BODY_CLASSES = {"postcolor", "post_body", "post-body"}

VOID_TAGS = {"area", "base", "br", "col", "embed", "hr", "img", "input",
             "link", "meta", "source", "wbr"}
BLOCK_TAGS = {"p", "div", "li", "tr", "br", "h1", "h2", "h3", "h4", "ul", "ol"}


def clean_text(text):
    """Схлопывает пробелы внутри строк и лишние пустые строки."""
    lines = [re.sub(r"[ \t\r\f\v\xa0]+", " ", ln).strip() for ln in text.splitlines()]
    out, blank = [], False
    for ln in lines:
        if not ln:
            if not blank and out:
                out.append("")
            blank = True
        else:
            out.append(ln)
            blank = False
    return "\n".join(out).strip()


class PostParser(HTMLParser):
    """Вытаскивает сообщения из HTML страницы темы.

    Стек открытых тегов хранит «роли» (post, author, date, body): текст
    попадает в буфер каждой роли, в которой сейчас находится.
    """

    def __init__(self, base_url):
        super().__init__(convert_charrefs=True)
        self.base_url = base_url
        self.stack = []          # [(tag, roles)]
        self.posts = []
        self.current = None      # сообщение, которое читаем сейчас
        self.bufs = None         # роль -> список кусков текста
        self.open_link = None    # <a>, внутри которого сейчас идёт текст

    def _roles(self, tag, attrs):
        classes = set((attrs.get("class") or "").split())
        roles = set()
        if tag == "div" and classes & POST_CLASSES:
            roles.add("post")
        if classes & AUTHOR_CLASSES:
            roles.add("author")
        if classes & DATE_CLASSES:
            roles.add("date")
        if classes & BODY_CLASSES:
            roles.add("body")
        return roles

    def _active_roles(self):
        return set().union(*(roles for _, roles in self.stack)) if self.stack else set()

    def handle_starttag(self, tag, attrs):
        attrs = dict(attrs)
        if tag in VOID_TAGS:
            if tag == "br" and self.current is not None:
                self.bufs["body"].append("\n")
            return

        roles = self._roles(tag, attrs)
        if "post" in roles:
            if self.current is None:
                post_id = (attrs.get("id") or "").replace("post-", "") or None
                self.current = {"post_id": post_id, "links": []}
                self.bufs = {"author": [], "date": [], "body": []}
            else:
                roles.discard("post")  # вложенный контейнер не начинает новое сообщение

        if self.current is not None:
            if tag in BLOCK_TAGS and "body" in self._active_roles():
                self.bufs["body"].append("\n")
            if tag == "a" and attrs.get("href") and "body" in self._active_roles():
                href = attrs["href"].strip()
                if href and not href.startswith(("#", "javascript:", "mailto:")):
                    self.open_link = {"url": urllib.parse.urljoin(self.base_url, href), "text": ""}
                    self.current["links"].append(self.open_link)

        self.stack.append((tag, roles))

    def handle_endtag(self, tag):
        if tag in VOID_TAGS:
            return
        # Закрываем до ближайшего открытого тега с таким именем: это переживает
        # незакрытые <p> и <li>, которых в форумной разметке много.
        for i in range(len(self.stack) - 1, -1, -1):
            if self.stack[i][0] == tag:
                popped = self.stack[i:]
                del self.stack[i:]
                if tag == "a":
                    self.open_link = None
                if self.current is not None and "body" in self._active_roles() and tag in BLOCK_TAGS:
                    self.bufs["body"].append("\n")
                for _, roles in popped:
                    if "post" in roles:
                        self._finish_post()
                return

    def handle_data(self, data):
        if self.current is None:
            return
        active = self._active_roles()
        for role in ("author", "date", "body"):
            if role in active:
                self.bufs[role].append(data)
        if self.open_link is not None:
            self.open_link["text"] += data

    def _finish_post(self):
        body = clean_text("".join(self.bufs["body"]))
        lines = [ln for ln in body.split("\n") if ln.strip()]
        title = lines[0] if lines else ""
        description = "\n".join(lines[1:]) if len(lines) > 1 else body

        links = []
        for link in self.current["links"]:
            links.append({"url": link["url"], "text": clean_text(link["text"])})

        self.posts.append({
            "post_id": self.current["post_id"],
            "author": clean_text("".join(self.bufs["author"])),
            "date": clean_text("".join(self.bufs["date"])),
            "title": title[:200],
            "description": description,
            "links": links,
        })
        self.current = None
        self.bufs = None
        self.open_link = None


def parse_posts(page_html, page_no, page_url):
    parser = PostParser(page_url)
    parser.feed(page_html)
    parser.close()
    for post in parser.posts:
        post["page"] = page_no
    return parser.posts


def page_url(topic, page, per_page):
    st = (page - 1) * per_page
    url = f"{BASE_URL}?showtopic={topic}"
    return url + (f"&st={st}" if st else "")


def decode_body(raw, content_type):
    match = re.search(r"charset=([\w-]+)", content_type or "", re.I)
    encodings = ([match.group(1)] if match else []) + ["utf-8", "cp1251"]
    for enc in encodings:
        try:
            return raw.decode(enc)
        except (UnicodeDecodeError, LookupError):
            continue
    return raw.decode("utf-8", errors="replace")


def fetch(url, retries=4, timeout=30):
    """Скачивает страницу. Повторяет только сетевые сбои и 429/5xx, не 403/404."""
    for attempt in range(retries + 1):
        try:
            req = urllib.request.Request(url, headers={"User-Agent": USER_AGENT})
            with urllib.request.urlopen(req, timeout=timeout) as resp:
                return decode_body(resp.read(), resp.headers.get("Content-Type"))
        except urllib.error.HTTPError as err:
            if err.code not in (429, 500, 502, 503, 504) or attempt == retries:
                raise
        except (urllib.error.URLError, TimeoutError):
            if attempt == retries:
                raise
        wait = 2 ** (attempt + 1)
        print(f"  повтор через {wait}с: {url}", file=sys.stderr)
        time.sleep(wait)
    raise RuntimeError("unreachable")


def load_page(url, cache_path, delay):
    if os.path.exists(cache_path):
        with open(cache_path, encoding="utf-8") as f:
            return f.read()
    text = fetch(url)
    with open(cache_path, "w", encoding="utf-8") as f:
        f.write(text)
    time.sleep(delay)
    return text


def dedup_key(post):
    if post["post_id"]:
        return f"id:{post['post_id']}"
    raw = f"{post['page']}|{post['author']}|{post['date']}|{post['title']}"
    return "h:" + hashlib.sha1(raw.encode("utf-8")).hexdigest()


def write_jsonl(posts, path):
    with open(path, "w", encoding="utf-8") as f:
        for post in posts:
            f.write(json.dumps(post, ensure_ascii=False) + "\n")


def write_markdown(posts, path, topic):
    with open(path, "w", encoding="utf-8") as f:
        f.write(f"# Модули темы {topic}: {len(posts)} шт.\n\n")
        for i, post in enumerate(posts, 1):
            f.write(f"## {i}. {post['title'] or '(без названия)'}\n\n")
            meta = [f"Автор: {post['author'] or '—'}", f"Дата: {post['date'] or '—'}",
                    f"Страница: {post['page']}"]
            f.write("  \n".join(f"- {m}" for m in meta) + "\n\n")
            if post["description"]:
                f.write(post["description"] + "\n\n")
            if post["links"]:
                f.write("Ссылки:\n")
                for link in post["links"]:
                    f.write(f"- [{link['text'] or link['url']}]({link['url']})\n")
                f.write("\n")


def main():
    ap = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--topic", default="603033", help="id темы (showtopic=...)")
    ap.add_argument("--pages", type=int, default=89, help="сколько страниц темы скачать")
    ap.add_argument("--per-page", type=int, default=PER_PAGE, help="сообщений на странице (st шаг)")
    ap.add_argument("--out", default=None, help="папка результата (по умолчанию output/topic_<id>)")
    ap.add_argument("--delay", type=float, default=1.0, help="пауза между запросами, сек")
    args = ap.parse_args()

    out = args.out or os.path.join("output", f"topic_{args.topic}")
    cache_dir = os.path.join(out, "cache")
    os.makedirs(cache_dir, exist_ok=True)

    all_posts, seen, failed = [], set(), []
    for page in range(1, args.pages + 1):
        url = page_url(args.topic, page, args.per_page)
        cache_path = os.path.join(cache_dir, f"page_{page:03d}.html")
        try:
            text = load_page(url, cache_path, args.delay)
        except Exception as err:  # продолжаем с остальными страницами
            print(f"[ошибка] стр. {page}: {err}", file=sys.stderr)
            failed.append(page)
            continue

        posts = parse_posts(text, page, url)
        if not posts:
            print(f"[предупреждение] стр. {page}: сообщения не найдены, "
                  f"проверьте селекторы по {cache_path}", file=sys.stderr)
        added = 0
        for post in posts:
            key = dedup_key(post)
            if key not in seen:
                seen.add(key)
                all_posts.append(post)
                added += 1
        print(f"стр. {page}/{args.pages}: сообщений {len(posts)}, новых {added}")

    write_jsonl(all_posts, os.path.join(out, "posts.jsonl"))
    write_markdown(all_posts, os.path.join(out, "modules.md"), args.topic)
    print(f"\nГотово: {len(all_posts)} сообщений -> {out}")
    if failed:
        print(f"Не скачаны страницы: {failed}. Повторный запуск докачает только их.")


if __name__ == "__main__":
    main()
