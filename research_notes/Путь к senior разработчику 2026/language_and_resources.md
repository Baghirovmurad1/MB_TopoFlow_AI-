# Second Language After Python (2026) and Zero-to-Senior Learning Resources

Research date: 2026-10-26. Status legend: **[verified]** = confirmed via a page fetched or searched this session. **[official URL, not re-verified]** = canonical official page, but edition, price or status was not re-checked this session. Time estimates marked "(estimate)" are my inferences, not sourced figures.

---

## Part A: Which second language pairs best with Python in 2026 (Rust vs Go vs TypeScript, plus a brief look at C/C++), especially for performance, AI, scientific computing (topology/laser-physics simulations) and cybersecurity?

### Takeaway
For this profile (performance, AI, scientific simulation, security), **Rust is the strongest complement to Python**. Today's fast Python tooling and ML infrastructure is written in Rust: uv, Ruff, ty, polars, pydantic-core and HF tokenizers. Rust links to Python through PyO3/maturin, and its share of Python native extensions is growing. Rust also has the top "admired" score (72%, Stack Overflow 2025). **Go** has more jobs (cloud/infra/DevOps) and is easier to learn, but it adds little to Python numerics. **TypeScript** is now #1 on GitHub by contributors and is the pragmatic pick for web/full-stack, but it does nothing for performance or simulation. **C/C++** is still worth *reading-level* literacy for CUDA, legacy scientific codes and exploit/reverse-engineering work.

### Cited Findings

**Popularity / adoption data**
- GitHub Octoverse 2025 (published 28 Oct 2025, covering Sep 2024–Aug 2025): TypeScript "overtook both Python and JavaScript in August 2025 to become the most used language on GitHub," measured by **monthly contributor count**. That was 2,636,006 contributors (+66.6% YoY), about 42k ahead of Python. The report itself notes that other indices may still rank Python/JS higher. — [GitHub Octoverse 2025](https://github.blog/news-insights/octoverse/octoverse-a-new-developer-joins-github-every-second-as-ai-leads-typescript-to-1/) **[verified]**
- Octoverse 2025: Python had ~2.6M contributors (+48% YoY) and is the leading language in AI-tagged repos (582,196 repos, +50.7% YoY). 1.1M+ public repos import an LLM SDK (+178% YoY). Rust and Go get no statistics on that page. — [GitHub Octoverse 2025](https://github.blog/news-insights/octoverse/octoverse-a-new-developer-joins-github-every-second-as-ai-leads-typescript-to-1/) **[verified]**
- Stack Overflow Developer Survey 2025, usage among all respondents: JavaScript 66%, Python 57.9%, TypeScript 43.6%, C++ 23.5%, C 22%, Go 16.4%, Rust 14.8%. Python adoption rose 7 percentage points from 2024 to 2025. — [Stack Overflow Survey 2025 – Technology](https://survey.stackoverflow.co/2025/technology) **[verified]**
- Stack Overflow 2025: Rust is the **most admired language at 72%**, ahead of Gleam (70%), Elixir (66%) and Zig (64%). — [Stack Overflow Survey 2025](https://survey.stackoverflow.co/2025/technology/), reported in [SD Times](https://sdtimes.com/softwaredev/report-rust-takes-the-crown-in-stack-overflow-developer-survey/). Admired percentages for Go and TypeScript could not be extracted (see Gaps).
- Stack Overflow 2025 tool usage: Cargo 14.4% as a package manager; uv 9.5%. — [Stack Overflow Survey 2025](https://survey.stackoverflow.co/2025/technology) **[verified]**. A secondary source says Cargo was the most admired dev tool at 71%. — [byteiota](https://byteiota.com/typescript-rust-go-surge-javascript-plateaus-2025/) (secondary)

**Rust ↔ Python ecosystem**
- PyO3 provides Rust bindings for Python. It can build native extension modules or embed Python in Rust, and **maturin** is the recommended tool for building and publishing Rust-based Python packages. Projects in its ecosystem list include **polars**, **pydantic-core**, Hugging Face **tokenizers**, **tiktoken** and **orjson**. The current README requires Rust ≥1.83 and CPython ≥3.9, and also supports PyPy and GraalPy. — [PyO3 GitHub](https://github.com/PyO3/pyo3); [PyO3 user guide](https://pyo3.rs/v0.24.1/)
- JetBrains/PSF State of Python 2025 (8th survey, >30,000 responses, data collected late 2024): Rust's share of Python binary extensions rose from **27% to 33%** in a year. — [heise](https://www.heise.de/en/news/Rust-becomes-Python-s-performance-co-pilot-10560471.html?view=print); [The New Stack](https://thenewstack.io/rust-pythons-new-performance-engine/); [ComputerWeekly](https://computerweekly.com/blog/Open-Source-Insider/JetBrains-details-state-of-Python-in-2025) (secondary coverage; I did not fetch the primary JetBrains page)
- Michael Kennedy, cited by heise: a quarter to a third of native code in new PyPI projects uses Rust. heise also reports that uv went from 0% to 11% among isolation/packaging tools in the survey. — [heise](https://heise.de/-10560471) (secondhand)
- Astral's uv (package/env manager), Ruff (linter/formatter) and ty (type checker) are all written in Rust. **OpenAI announced on 19 March 2026 that it is acquiring Astral.** The team joins the Codex division, and OpenAI pledged continued support for uv, Ruff and ty. uv was reported at >126M monthly downloads. — [SiliconANGLE](https://siliconangle.com/2026/03/19/openai-acquires-open-source-python-tooling-startup-astral/); [The New Stack](https://thenewstack.io/openai-astral-acquisition/); [CIO](https://www.cio.com/article/4147870/openai-buys-non-ai-coding-startup-to-help-its-ai-to-program-2.html)
- ty entered **beta in December 2025**, with a stable 1.0 targeted for 2026. As of the latest release found (0.0.69, 6 Aug 2026) it is still pre-1.0. — [InfoWorld](https://www.infoworld.com/article/4108979/python-type-checker-ty-now-in-beta.html); [pydevtools ty beta](https://pydevtools.com/blog/ty-beta/); [newreleases ty 0.0.69](https://newreleases.io/project/github/astral-sh/ty/release/0.0.69)

**Job demand: Rust vs Go (weak sources, treat as rough)**
- A LinkedIn post claims Go has 3–4× more open roles than Rust, while Rust listings grew ~35% YoY. Another analysis counts ~606 Rust roles (Feb 2026), roughly doubled over two years. Salary figures across these blogs conflict, e.g. Rust $178k vs Go $165k in one, and medians of $155k vs $140k in another, with no dataset cited. — [tech-insider rust vs go 2026](https://tech-insider.org/rust-vs-go-2026/); [langpop](https://langpop.com/blog/rust-vs-go-systems-programming); [hakia](https://hakia.com/news/best-programming-languages-2026/) (all secondary, low confidence)
- Go dominates cloud-native tooling (much of the CNCF ecosystem). Rust demand is concentrated in safety-critical sectors and infrastructure. One source claims 48.8% of organizations used Rust in production in 2025. — [tech-insider](https://tech-insider.org/rust-vs-go-2026/) (secondary; the 48.8% figure probably comes from the Rust Foundation/State of Rust survey, but I did not verify it)
- UK job-trend tracker for Rust (London), useful for live demand data. — [ITJobsWatch Rust London](https://www.itjobswatch.co.uk/jobs/london/rust.do)

### Inferences
- **Fit to the stated interests:**
  - *Performance/scientific simulation:* Rust (via PyO3/maturin) lets you write hot loops for topology or laser-physics simulations, for example ODE/PDE solvers or ray/beam propagation, and call them from NumPy/Python, with memory safety. C/C++ is the incumbent here (Eigen, CUDA, legacy Fortran/C++ physics codes), so the ability to *read* C++ stays valuable.
  - *AI:* The Python AI stack's performance layer is mostly C++/CUDA (PyTorch) and, increasingly, Rust (tokenizers, polars, safetensors). Rust is the growing option, and C++/CUDA is the established one.
  - *Cybersecurity:* Rust is increasingly used for security tooling and memory-safe rewrites. Exploit dev and reverse engineering need C and assembly literacy. Go is common for offensive and network tooling because it compiles to static binaries.
  - *Jobs/cloud:* Go wins on job count and simplicity. TypeScript wins for web products.
- **Recommended path for this profile:** Python first, then Rust as the second language, then C reading literacy (gained naturally through CS:APP/Nand2Tetris). Learn TypeScript later, only if building web UIs. Go is the better choice only if the person targets DevOps/SRE/cloud backend jobs.
- **Time to productivity (estimates, not sourced):**
  - Go: about 2–4 weeks to write useful code, because the language is small.
  - TypeScript: 2–6 weeks for someone who knows JS basics. Senior-level type gymnastics takes months.
  - Rust: about 2–4 months before fighting the borrow checker stops dominating, and 6–12 months to be comfortable with async, lifetimes and unsafe.
  - C: weeks to write simple programs. Writing *safe* C/C++ takes years.

### Gaps
- I could not extract Stack Overflow 2025 "admired" percentages for Go, TypeScript, Python, C or C++ because the page was truncated. The report writer should not invent them.
- No primary, authoritative job-posting dataset (e.g., Indeed/LinkedIn index) comparing Rust, Go and TypeScript in 2026 was found. Only blogs.
- I found no published, survey-based "time to productivity" figures per language. The estimates above are inference.
- The JetBrains State of Python 2025 primary page was not fetched. Figures come via heise and The New Stack.
- Whether the OpenAI–Astral acquisition has closed, or has changed uv/Ruff/ty licensing, was not confirmed after March 2026.

---

## Part B: The best resources for going from zero to senior-level Python/software engineering (2026 status, cost, estimated hours)

### Takeaway
A credible zero-to-senior path combines four parts:
1. **Free structured foundations:** CS50P/CS50x, the official Python tutorial, Exercism.
2. **Intermediate-to-advanced Python books:** Fluent Python 2e, Effective Python 3e (125 items, Python 3.13), Robust Python, Cosmic Python, the pytest book.
3. **CS fundamentals following teachyourselfcs.com.**
4. **Architecture and systems books:** DDIA 2e (out Feb/Mar 2026), Fundamentals of Software Architecture 2e (Mar 2025), A Philosophy of Software Design.

Add project-based practice on top: CodeCrafters, build-your-own-x, Advent of Code. Modern tooling now means uv, Ruff, ty/pyright/mypy, pytest, FastAPI, Pydantic v2 and SQLAlchemy 2.

### Cited Findings

**B1. Python foundations**
- **CS50P (Harvard, Intro to Programming with Python):** 10 weeks (0–9), **free** via OpenCourseWare. Paid verified certificates and professional certificates are offered through edX (cs50.edx.org/python). Harvard recommends CS50x for CS in general (C, Python, SQL, JS), taken before, during or after CS50P. — [CS50P](https://cs50.harvard.edu/python/) **[verified]**. Time estimate: ~60–100 h for CS50P and ~100–200 h for CS50x (estimate).
- **Official Python tutorial:** free. — [docs.python.org tutorial](https://docs.python.org/3/tutorial/) [official URL, not re-verified]. Estimate ~10–20 h.
- **Exercism Python track:** free, with optional volunteer human mentoring. — [Exercism Python](https://exercism.org/tracks/python) [official URL, not re-verified]
- **Boot.dev:** gamified backend path (Python, Go, SQL, etc.). The **annual plan is $399/yr**. The monthly price is contested ($59/mo in a Sept 2026 review vs $33/mo on a directory page). 30-day money-back guarantee. Content can be read free, but interactive features are paid. — [Boot.dev pricing](https://boot.dev/pricing); [onlinecourseing review](https://onlinecourseing.com/boot-dev-review/); [techinterview directory](https://www.techinterview.org/bootcamp_directory/p/boot-dev/) (conflicting monthly figures)
- **Automate the Boring Stuff with Python (Al Sweigart):** free to read online, with a paid print edition (No Starch). — [automatetheboringstuff.com](https://automatetheboringstuff.com/) [official URL, not re-verified; a 3rd edition was announced for 2025, not verified]
- **Python Crash Course (Eric Matthes, No Starch, 3rd ed. 2023):** — [No Starch](https://nostarch.com/python-crash-course-3rd-edition) [official URL, not re-verified]
- **Fluent Python 2nd ed. (Luciano Ramalho, O'Reilly, 2022):** the standard "deep Python" book (data model, iterators, async, metaprogramming). — [O'Reilly](https://www.oreilly.com/library/view/fluent-python-2nd/9781492056348/) [official URL, not re-verified]
- **Effective Python 3rd ed. (Brett Slatkin, Addison-Wesley):** **125 items** (up from 90), 35 new items, covers Python up to **3.13**, with new chapters on robustness/performance and C extensions/native libraries. O'Reilly lists it as November 2024 (672 pp); a retailer lists the print edition as 26 Feb 2025. — [O'Reilly listing](https://www.oreilly.com/library/view/effective-python-125/9780138172398); [InformIT](https://informit.com/store/effective-python-125-specific-ways-to-write-better-9780138172183); [Schweitzer](https://www.schweitzer-online.de/en/buch/Slatkin/Effective-Python/9780138172183/A66200223/) **[verified]**
- **Robust Python (Patrick Viafore, O'Reilly, 2021):** typing and maintainability. — [O'Reilly](https://www.oreilly.com/library/view/robust-python/9781098100650/) [official URL, not re-verified]
- **Architecture Patterns with Python, a.k.a. "Cosmic Python" (Percival & Gregory, O'Reilly, 2020):** DDD, repository, unit of work, events. **Free to read online.** — [cosmicpython.com](https://www.cosmicpython.com/) [official URL, not re-verified]
- **Python Testing with pytest 2nd ed. (Brian Okken, Pragmatic Bookshelf, 2022).** — [Pragmatic](https://pragprog.com/titles/bopytest2/python-testing-with-pytest-second-edition/) [official URL, not re-verified]

**B2. Modern Python tooling (2026)**
- **uv / Ruff / ty (Astral, Rust-based):**
  - uv is the package/env manager, at >126M monthly downloads.
  - Ruff is the linter and formatter.
  - ty is the type checker: beta since December 2025, still 0.0.x in August 2026, with stable targeted for 2026.
  - Astral is being acquired by OpenAI (announced 19 March 2026), which pledged continued support.
  - Sources: [SiliconANGLE](https://siliconangle.com/2026/03/19/openai-acquires-open-source-python-tooling-startup-astral/); [InfoWorld ty beta](https://www.infoworld.com/article/4108979/python-type-checker-ty-now-in-beta.html); [newreleases ty](https://newreleases.io/project/github/astral-sh/ty/release/0.0.69) **[verified]**
- uv went from 0% to 11% among packaging/isolation tools in the JetBrains 2025 survey (data from late 2024), and is at 9.5% in Stack Overflow 2025. — [heise](https://heise.de/-10560471); [SO 2025](https://survey.stackoverflow.co/2025/technology)
- **pydantic-core** (Pydantic v2's validation engine) is written in Rust via PyO3. — [PyO3 README](https://github.com/PyO3/pyo3)
- FastAPI, SQLAlchemy 2.0, mypy/pyright and asyncio docs: [FastAPI](https://fastapi.tiangolo.com/), [SQLAlchemy 2.0 tutorial](https://docs.sqlalchemy.org/en/20/tutorial/), [mypy](https://mypy.readthedocs.io/), [pyright](https://github.com/microsoft/pyright), [asyncio docs](https://docs.python.org/3/library/asyncio.html) [official URLs, not re-verified]

**B3. CS fundamentals**
- **CS50x:** free, covers C, Python, SQL and JS. — [CS50P page referencing CS50x](https://cs50.harvard.edu/python/) **[verified]**; [CS50x](https://cs50.harvard.edu/x/)
- **teachyourselfcs.com** curriculum: Programming (SICP / Composing Programs), Architecture (Nand2Tetris, CS:APP), Algorithms, Math, OS (OSTEP), Networking (Kurose & Ross), Databases (CMU 15-445), Languages/Compilers, Distributed Systems (DDIA). It suggests ~100–200 h per subject. — [teachyourselfcs.com](https://teachyourselfcs.com/) [official URL, not re-verified; the hours figure is from memory of the site, so verify]
- **MIT 6.100L** (Intro to CS & Programming using Python, free on OCW). — [MIT OCW 6.100L](https://ocw.mit.edu/courses/6-100l-introduction-to-cs-and-programming-using-python-fall-2022/) [not re-verified]
- **Composing Programs** (free, Python-based SICP, from Berkeley CS61A). — [composingprograms.com](https://www.composingprograms.com/)
- **Nand2Tetris** (free course and book, "The Elements of Computing Systems" 2nd ed. 2021). — [nand2tetris.org](https://www.nand2tetris.org/)
- **OSTEP** (Operating Systems: Three Easy Pieces, free online). — [OSTEP](https://pages.cs.wisc.edu/~remzi/OSTEP/)
- **CS:APP** (Bryant & O'Hallaron, 3rd ed., paid textbook). — [CS:APP](https://csapp.cs.cmu.edu/)
- **Computer Networking: A Top-Down Approach** (Kurose & Ross, 8th ed., Pearson; free lecture videos and slides on the authors' site). — [gaia.cs.umass.edu/kurose_ross](https://gaia.cs.umass.edu/kurose_ross/)
- **CMU 15-445/645 Databases** (free lectures on YouTube, BusTub C++ projects). — [CMU 15-445](https://15445.courses.cs.cmu.edu/)
- **Grokking Algorithms** (Bhargava, Manning, 2nd ed. 2024): a gentle, illustrated intro. — [Manning](https://www.manning.com/books/grokking-algorithms-second-edition) [not re-verified]
- **NeetCode / LeetCode:** mainly for interview preparation. The NeetCode 150 roadmap is free, with a paid "Pro" tier. — [neetcode.io](https://neetcode.io/) [not re-verified]. (Community opinion, not sourced here: in 2026, LeetCode-style rounds persist at big tech, but they matter less for senior roles than system design and practical coding.)

**B4. Engineering / architecture**
- **Designing Data-Intensive Applications, 2nd ed.** (Martin Kleppmann **and Chris Riccomini**, O'Reilly): **released**, 670 pages. It integrates new technologies and adds coverage of how major cloud services are designed for scalability, fault tolerance and consistency. Kleppmann's site says March 2026; the O'Reilly catalog lists February 2026. Print ISBN 9781098119065. — [Kleppmann blog, 24 Mar 2026](https://martin.kleppmann.com/2026/03/24/designing-data-intensive-applications-2e.html); [O'Reilly](https://www.oreilly.com/library/view/designing-data-intensive-applications/9781098119058/) **[verified]**
- **Fundamentals of Software Architecture 2nd ed.** (Mark Richards & Neal Ford, O'Reilly): **March 2025**, 546 pp, **five new chapters** (including generative AI and team topologies, plus updated patterns, governance and data), with an audiobook in September 2025. Print ISBN 9781098175511. — [O'Reilly](https://www.oreilly.com/library/view/-/9781098175504); [WorldCat](https://search.worldcat.org/title/1507801941) **[verified]**
- **A Philosophy of Software Design 2nd ed.** (John Ousterhout, 2021): deep vs shallow modules, complexity. — [Stanford/Ousterhout page](https://web.stanford.edu/~ouster/cgi-bin/book.php) [not re-verified]
- **System Design Interview Vol. 1 & 2** (Alex Xu, ByteByteGo). — [ByteByteGo](https://bytebytego.com/) [not re-verified]
- **Software Engineering at Google** (Winters, Manshreck, Wright, O'Reilly 2020): **free online**. — [abseil.io/resources/swe-book](https://abseil.io/resources/swe-book) [not re-verified]
- **The Pragmatic Programmer, 20th Anniversary ed.** (2019). — [Pragmatic Bookshelf](https://pragprog.com/titles/tpp20/the-pragmatic-programmer-20th-anniversary-edition/) [not re-verified]
- **Clean Architecture/Clean Code critiques:** I did not fetch these this session (see Gaps).
- **AI Engineering** (Chip Huyen, O'Reilly): ten chapters covering foundation models, evaluation (2 chapters), prompt engineering, RAG and agents, fine-tuning, dataset engineering, inference optimization and architecture. — [computingforgeeks review](https://computingforgeeks.com/best-llm-engineering-books/) (secondary; the O'Reilly early-2025 date was not verified this session)
- **Build a Large Language Model (From Scratch)** (Sebastian Raschka, Manning, Sept 2024): builds a GPT-2-class model trainable on a laptop, covering data prep, pretraining, fine-tuning and loading pretrained weights. — [O'Reilly listing of Manning title](https://oreilly.com/library/view/build-a-large/9781633437166) **[verified]**; free code at [GitHub rasbt/LLMs-from-scratch](https://github.com/rasbt/LLMs-from-scratch) [not re-verified]

**B5. Project-based learning**
- **CodeCrafters:** "build your own Redis/Git/HTTP server/SQLite/DNS…" in many languages. Some free material (challenges rotate as free), and paid membership unlocks the full catalog. A third party lists $30–39/month, which is unverified on the official page. Students at some partner universities and Hack Club members get free memberships. — [CodeCrafters pricing](https://codecrafters.io/pricing); [AlternativeTo](https://alternativeto.net/software/codecrafters/about); [Hack Club offer](https://codecrafters.io/event/hackclub)
- **build-your-own-x** (free GitHub list of tutorials maintained by CodeCrafters). — [GitHub](https://github.com/codecrafters-io/build-your-own-x)
- **Advent of Code** (free, December puzzles). — [adventofcode.com](https://adventofcode.com/)
- **roadmap.sh** (free Python, Backend and Software Architect roadmaps). — [Python](https://roadmap.sh/python), [Backend](https://roadmap.sh/backend), [Software Architect](https://roadmap.sh/software-architect) [not re-verified]

**B6. Second-language resources**
- **Rust:** The Rust Programming Language ("the Book", free) — [doc.rust-lang.org/book](https://doc.rust-lang.org/book/). Rustlings (free exercises) — [GitHub rust-lang/rustlings](https://github.com/rust-lang/rustlings). Rust for Rustaceans (Jon Gjengset, No Starch 2021, intermediate/advanced) — [No Starch](https://nostarch.com/rust-rustaceans). Zero To Production in Rust (Luca Palmieri, self-published, backend/web) — [zero2prod.com](https://www.zero2prod.com/). PyO3 guide — [pyo3.rs](https://pyo3.rs/v0.24.1/). [Rust resources: official URLs, not re-verified; zero2prod edition details not found in search]
- **Go:** A Tour of Go (free) — [go.dev/tour](https://go.dev/tour/). **Learning Go 2nd ed.** (Jon Bodner, O'Reilly, **January 2024**, 494 pp, adds generics) — [O'Reilly](https://www.oreilly.com/library/view/-/9781098139285) **[verified]**
- **TypeScript:** TypeScript Handbook (free) — [typescriptlang.org/docs/handbook](https://www.typescriptlang.org/docs/handbook/). Total TypeScript (Matt Pocock; free beginner material plus paid workshops) — [totaltypescript.com](https://www.totaltypescript.com/) [not re-verified]

### Inferences
- **Suggested sequencing and hours (estimates, not sourced):**
  1. **0→junior, ~400–600 h:** CS50P → official tutorial → Python Crash Course or Automate the Boring Stuff → Exercism (50+ exercises) → CS50x.
  2. **Junior→mid, ~600–1000 h:** Fluent Python 2e and Effective Python 3e, then Robust Python and the pytest book. Learn modern tooling (uv, Ruff, pyright/ty, pytest, FastAPI + Pydantic v2 + SQLAlchemy 2) and build 2–3 deployed projects. Add CodeCrafters Redis/HTTP server and Advent of Code.
  3. **Mid→senior, ~1000–2000 h plus real job experience:** teachyourselfcs core (Composing Programs, Nand2Tetris, CS:APP, OSTEP, Kurose & Ross, CMU 15-445), then Cosmic Python, A Philosophy of Software Design, Fundamentals of Software Architecture 2e, DDIA 2e, Software Engineering at Google (free) and System Design Interview.
  4. **For the AI focus:** Raschka, then Huyen.
  5. **In parallel from the mid stage:** Rust Book → Rustlings → a PyO3 extension that accelerates a physics kernel.
- Overall: **3–5 years** to "senior". Seniority depends on production experience (on-call, code review, design ownership), not resource count alone. This is an inference, since no source quantifies it.
- **Cost profile:** a nearly free path is possible (CS50, docs, Exercism, Cosmic Python, SWE at Google, OSTEP, Composing Programs, Nand2Tetris, Rust Book, Tour of Go). Paid options: books (~$40–70 each, estimate), Boot.dev ($399/yr) and CodeCrafters (~$30–39/mo, third-party figure).

### Gaps
- Not re-verified this session: current prices, editions and free status for Automate the Boring Stuff (possible 3rd ed. 2025), Python Crash Course, Fluent Python, Robust Python, Cosmic Python, pytest book, Grokking Algorithms 2e, Rust for Rustaceans, Zero To Production, Total TypeScript, NeetCode Pro, MIT 6.100L, Kurose & Ross edition. The URLs are canonical official pages, but the report writer should treat their edition and price details as unverified.
- Boot.dev's monthly price is contested between sources ($59 vs $33). Only $399/yr is consistent.
- CodeCrafters' official price was not visible. $30–39/mo is a third-party figure.
- The O'Reilly publication date of Chip Huyen's *AI Engineering* (believed to be early 2025) was not confirmed from a primary source this session.
- "Clean Architecture"/"Clean Code" critiques (e.g., the Ousterhout–Martin debate, the qntm "It's probably time to stop recommending Clean Code" essay) were not fetched. Mention them only as community opinion, without a cited URL, unless verified.
- No sourced hour estimates exist for most books and courses. All hour figures above are my estimates. Only teachyourselfcs gives a per-subject guideline, and that was not re-verified.
- I did not research the role of NeetCode/LeetCode in 2026 hiring from a reliable source. Any claim about it is opinion.
