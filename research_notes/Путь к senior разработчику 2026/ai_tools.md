# AI tools for a self-taught programmer (status as of late October 2026): capabilities, learning features, free/cheap tiers, allocation

> Research date: 2026-10-26. Several free tiers changed sharply in 2026 (Gemini CLI free tier ended, Copilot moved to AI credits and paused signups for two months, ChatGPT added ads and new free models, Firebase Studio is being shut down). Many exact quota numbers come only from third-party sources. These are labeled, and the user should re-check them on the official pages before relying on them.

## Q1. Claude (claude.ai, Learning mode, Projects, Artifacts, Claude Code output styles, pricing)

### Takeaway
Claude has the most developed "learn-by-doing" coding mode of any tool covered. Claude Code's **Learning** output style leaves `TODO(human)` gaps for the learner to write the code with real design decisions in it. **Explanatory** adds `Insight` blocks. On claude.ai, Learning mode has been open to all users since Aug 2025. Claude Code requires Pro ($20/mo) or higher. The Free plan covers chat, Projects (max 5) and Artifacts.

### Cited Findings
- **Claude Code output styles (official docs, current):** besides Default there are four built-in styles: Proactive, Concise, **Explanatory** and **Learning**. Explanatory "adds short `Insight` blocks that explain the choices behind the code it writes" (2–3 points about your codebase per block). These blocks appear in the conversation, not as file comments. — [Claude Code docs: Output styles](https://code.claude.com/docs/en/output-styles)
- **Learning style:** Claude handles routine implementation itself. When it reaches "a piece with a real design decision, such as error handling, a data structure, or business logic with more than one valid approach, it leaves a few lines for you". It marks the spot with a `TODO(human)` comment, sends a "Learn by Doing" request (Context / Your Task / Guidance), then **stops and waits**. After you write the code it gives one `Insight` about it. — [Claude Code docs: Output styles](https://code.claude.com/docs/en/output-styles)
- How to switch: `/output-style <style>` (requires v2.1.269+), `/config → Output style`, or `"outputStyle": "Learning"` in `.claude/settings.local.json` or `~/.claude/settings.json` (the value is case-sensitive). You can write **custom output styles** as Markdown files in `~/.claude/output-styles`. This is useful for building your own "Socratic tutor" style; set `keep-coding-instructions: true` to keep Claude's coding behaviour. — [Claude Code docs: Output styles](https://code.claude.com/docs/en/output-styles)
- Explanatory and Learning "produce longer responses than Default by design, which increases output tokens", so they use up plan limits faster. — [Claude Code docs: Output styles](https://code.claude.com/docs/en/output-styles)
- Conflicting doc versions: a search snippet of an earlier docs version said `/output-style` was deprecated in v2.1.73 and removed in v2.1.91 in favour of `/config`. The current docs page lists `/output-style` as working again (v2.1.269+). — [docs .md snippet](https://code.claude.com/docs/en/output-styles.md) vs [current docs](https://code.claude.com/docs/en/output-styles)
- **Learning mode on claude.ai:** first introduced in April 2025 only for Claude for Education. It opened to all users on Aug 14, 2025, together with the Claude Code Explanatory and Learning styles. It works through Socratic guided questions and is turned on from the style menu. — [Engadget, Apr 2025](https://engadget.com/ai/claudes-new-learning-mode-will-prompt-students-to-answer-questions-on-their-own-172057828.html); [Engadget, Aug 2025](https://engadget.com/ai/anthropic-brings-claudes-learning-mode-to-regular-users-and-devs-170018471.html); [Tom's Guide](https://www.tomsguide.com/ai/claudes-new-learning-modes-take-on-chatgpts-study-mode-heres-what-they-do); [AlternativeTo](https://alternativeto.net/news/2025/8/claude-s-learning-mode-is-now-available-to-all-users-with-new-coding-styles)
- **Pricing (official page, current):**
  - **Free $0:** Sonnet and Haiku only. No Claude Code. Up to 5 Projects. Artifacts included. Web search, file creation, code execution and memory are included.
  - **Pro:** $20/mo monthly or $17/mo billed annually. Includes Claude Code and "at least 5x Free per 5-hour session". Weekly limits apply.
  - **Max:** from $100/mo, at 5x or 20x Pro. Includes $100–200/mo in API credits.
  - Limits reset on a rolling 5-hour window. Web, desktop, mobile and Claude Code share one usage pool. Paid plans can buy "usage credits" at API rates.
  - The page also mentions an Education plan with "learning mode", plus Claude Academy, courses and tutorials.
  — [claude.com/pricing](https://claude.com/pricing)
- **Anthropic guidance for learners:** the free "AI Fluency for Students" course from Anthropic Academy is also on Coursera (~3 h, beginner, updated May 2026). It is built on the 4D framework (Delegation, Description, Discernment, Diligence) and focuses on building independent skills while using AI. — [Coursera](https://www.coursera.org/learn/ai-fluency-for-students); [Coursera blog](https://blog.coursera.org/anthropic-launches-five-free-courses-on-coursera-to-help-build-ai-fluency/); [Anthropic blog](https://claude.com/blog/anthropics-approach-to-teaching-and-learning-ai)

### Inferences
- Claude Code with the **Learning** style is the best tool here for "build a real project while still writing the key parts yourself". It suits learning a new codebase, a framework or a language on a project.
- Free Claude is enough for Socratic Learning-mode chat and small Artifacts (interactive visualizations of algorithms). Pro is worth paying for mainly because of Claude Code.
- A custom output style (for example "never write more than N lines; ask a question first") turns Claude Code into a tutor that resists over-helping.

### Gaps
- The Free tier's exact message counts are not published; the page says only "covers everyday questions".
- I found no official 2026 Anthropic page describing claude.ai Learning mode in detail; the details come from 2025 press coverage.

## Q2. Google Gemini ecosystem (Gemini app Guided Learning, NotebookLM, AI Studio, Gemini CLI → Antigravity, Jules, Firebase Studio, Colab, student offers)

### Takeaway
Google is the most generous ecosystem for learning **content**: Gemini Guided Learning, NotebookLM flashcards, quizzes and Audio/Video Overviews, and a free API in AI Studio. For **free coding agents** it has become much less generous in 2026. Gemini CLI stopped serving free and individual accounts on June 18, 2026 and was replaced by Antigravity CLI and Antigravity IDE, which have small weekly free quotas. Firebase Studio shuts down in March 2027. US college students can get a free year of Google AI Pro (redeem by Dec 31, 2026). Students in other markets get AI Plus.

### Cited Findings
- **Gemini Guided Learning:** launched Aug 6, 2025, a week after ChatGPT Study Mode. It is a toggle in the prompt box for all users. It walks you through a problem step by step, using images, diagrams, videos and interactive quizzes instead of handing over the answer. — [TechCrunch](https://techcrunch.com/2025/08/06/google-takes-on-chatgpts-study-mode-with-new-guided-learning-tool-in-gemini/)
- Guided Learning is powered by LearnLM, a family of education-tuned models built into Gemini 2.5 Pro at launch. — [ForkLog](https://forklog.com/en/google-transforms-gemini-into-an-ai-tutor/)
- **Student offer 2026:** eligible US college students get 12 months of Google AI Pro free (normally $19.99/mo; includes higher Gemini limits, Gemini in Gmail and Docs, and 5 TB of storage). Students verify through SheerID at one.google.com/ai-student, and the deadline to redeem is **Dec 31, 2026**. The plan auto-renews as paid after 12 months. — [MacRumors, Aug 19, 2026](https://macrumors.com/2026/08/19/students-free-year-google-ai-pro); [Tom's Guide](https://www.tomsguide.com/ai/google-gemini/google-is-giving-students-a-free-year-of-gemini-pro-plus-new-ai-study-features)
- Students outside the US (140+ markets) reportedly get **Google AI Plus** free for 12 months instead. A student hub at gemini.google.com/students offers study notebooks, flashcards and quizzes. — [Tom's Guide](https://www.tomsguide.com/ai/google-gemini/google-is-giving-students-a-free-year-of-gemini-pro-plus-new-ai-study-features); [Dupple](https://dupple.com/learn/how-to-get-gemini-pro-for-free)
- **NotebookLM** (on Google for Education pages now partly branded "Gemini Notebook"):
  - Builds flashcards and interactive practice quizzes "based exclusively on the sources you upload".
  - Has a Guided Learning-style mode for "deep understanding of your sources instead of just quick answers".
  - Creates study guides with key terms, quizzes with answer keys and essay questions.
  - Also makes Audio Overviews, Video Overviews, slide decks and mind maps. Answers carry inline citations back to the sources.
  - Different versions of the page give different quiz and flashcard limits (100/day vs 10/day per user).
  — [Google for Education: NotebookLM](https://edu.google.com/intl/ALL_us/ai-notebooklm); [Google for Education (AU variant)](https://edu.google.com.au/intl/ALL_au/ai-gemini-notebook/?pt_ref=ai)
- NotebookLM in 2026:
  - "Cinematic Video Overviews" launched Mar 4, 2026 (Gemini 3, Nano Banana Pro and Veo 3). One source says they are Ultra-only.
  - Gemini 3.5 became the default model on June 8, 2026, according to a single timeline source.
  - Drive auto-sync arrived May 19, 2026 and EPUB support in Mar 2026.
  — [BuildFastWithAI](https://www.buildfastwithai.com/blogs/notebooklm-cinematic-video-overview-full-guide-2026); [Glasp timeline](https://glasp.ai/articles/notebooklm-2026)
- NotebookLM free "Standard" limits (third-party, Jul 2026): 100 notebooks, 50 sources per notebook, 50 chat queries/day, 3 Audio Overviews/day, 3 Video Overviews/day, 10 reports/day, 10 Deep Research sessions/month. Sources disagree on paid prices. — [DailyAIFixs](https://dailyaifixs.com/blog/notebooklm-free-plan-2026-what-s-the-real-catch)
- Workspace for Education Plus and Teaching & Learning customers got higher NotebookLM limits, including more flashcards and quizzes (Apr 13, 2026). — [Google Workspace Updates](https://workspaceupdates.googleblog.com/2026/04/expanded-notebooklm-capabilities-for-Education-Plus-and-Teaching-and-Learning-add-on-customers.html)
- **Gemini CLI → Antigravity CLI:** the official quota page says: "Unpaid tier and Google One users: Gemini CLI was replaced by Antigravity CLI on June 18th, 2026." The same page still lists the old figures of 1000 req/day for a Google login and 250/day for an unpaid API key (Flash only), so parts of it look out of date. — [geminicli.com quota page](https://geminicli.com/docs/resources/quota-and-pricing/)
- Gemini CLI remains available to enterprise Code Assist customers and to people using paid API keys. Antigravity CLI is written in Go and is not open source. — [LetsDataScience](https://letsdatascience.com/news/google-replaces-gemini-cli-with-antigravity-cli-574b2056); [The Register, May 20, 2026](https://www.theregister.com/ai-ml/2026/05/20/bye-bye-gemini-cli-google-nudges-devs-toward-antigravity/5243605)
- Antigravity CLI free quota is unofficial. One source says about 20 agent requests/day, down from 1,000. Another says the cap is weekly and compute-based. — [gradually.ai](https://www.gradually.ai/en/antigravity-cli-commands/); [AIWeekly](https://aiweekly.co/node/3134)
- **Antigravity IDE:**
  - $0 for personal Google accounts, with "basic weekly rate limits" plus unlimited Tab completions and command requests. Quota is tied to work done by the agent, not a fixed prompt count.
  - Paid quota comes through Google AI Pro ($19.99) or Ultra.
  - A review dated around Oct 2026 says Claude Sonnet and Opus 4.6 and GPT-OSS-120b will be removed from the free tier on **Nov 2, 2026**, leaving only Gemini models.
  — [Preuve review](https://preuve.ai/blog/antigravity-review); [CloudZero](https://www.cloudzero.com/blog/google-antigravity-pricing/)
- **Google AI Studio / Gemini API free tier:** a free tier exists, limited per project in RPM, TPM and RPD. RPD resets at midnight Pacific. It is not for commercial use, and free-tier data may be used to improve Google's products. Figures conflict for Gemini 3.5 Flash: one source quotes AI Studio's rate-limit screen at **20 RPD** (with 1,500/day applying to Gemma), while another gives ~15 RPM / 1,500 RPD for Flash. Pro models reportedly left the free tier in Apr 2026. — [Tilnote](https://tilnote.io/pages/6a51b3398d9a59d14c1c174c); [TinkerLLM](https://tinkerllm.com/blog/gemini-api-free-tier-limits-rate-quotas/); [Yingtu](https://yingtu.ai/en/blog/google-gemini-api-free-tier-limits-2026); official page: [ai.google.dev rate limits](https://ai.google.dev/gemini-api/docs/rate-limits)
- **Jules (async coding agent):** out of beta Aug 2025. The free "introductory access" tier allows 15 tasks/day and 3 concurrent tasks. AI Pro and Ultra raise this 5x and 20x. A Mar 2026 comparison lists Pro at ~75 tasks/day and 15 concurrent. Sources differ on the model: Gemini 3 Flash on free versus Gemini 3.1 Pro on paid in 2026, against Gemini 2.5 Pro at launch. — [TechCrunch](https://techcrunch.com/2025/08/06/googles-ai-coding-agent-jules-is-now-out-of-beta); [MorphLLM](https://www.morphllm.com/comparisons/jules-google-coding-agent)
- **Firebase Studio:** shuts down on **Mar 22, 2027** (announced Mar 2026). Creating new workspaces is reportedly disabled from June 2026. Google points users to AI Studio (browser prototyping) and Antigravity (IDE). Core Firebase (Firestore, Auth, App Hosting) is unaffected. — [Storyboard18](https://www.storyboard18.com/digital/google-to-shut-firebase-studio-in-2027-shifts-focus-to-ai-studio-and-antigravity-92922.htm); [StartupTalky](https://startuptalky.com/news/google-plans-firebase-studio-shutdown/)

### Inferences
- **NotebookLM** is best for "learning from documentation and books": load docs, an RFC or a book and get quizzes, flashcards and audio for spaced repetition. It is grounded only in your sources, which reduces hallucinations.
- **Gemini Guided Learning** is a free alternative to Claude Learning mode and ChatGPT Study Mode for theory such as algorithms and CS fundamentals, with visual aids.
- **AI Studio free API** is useful for a first project calling an LLM API. Do not plan on large free daily volumes in 2026, because the 3.5 Flash daily caps may be small.
- **Do not build a learning plan on Gemini CLI or Firebase Studio.** The first is replaced for free users; the second is being shut down.
- **Jules** (15 free tasks/day) suits learning to work with an async agent: write an issue, review the PR, read the diff. That is useful practice for code-review skills.

### Gaps
- No primary source for Antigravity CLI and IDE free limits; Google publishes no fixed counts.
- **Colab with Gemini** and **Gemini Code Assist for individuals (IDE plugin)**: no current 2026 data found. Code Assist for individuals is probably affected by the same June 18, 2026 change (the geminicli quota page ties the 1000/day quota to "Gemini Code Assist for individuals"), but this is unverified.
- No official Google confirmation found for "Learn Your Way" (Google Research's AI-reimagined textbooks project).
- The official blog.google posts on Guided Learning and NotebookLM could not be opened.

## Q3. ChatGPT (Study Mode, voice, Codex, canvas, Pulse, Free/Go/Plus/Pro, GPT-5.x models)

### Takeaway
Study Mode (Jul 2025) is available on all plans, including Free. Since Aug 2026 the Free tier reportedly gets unlimited text chats, but only with the small "GPT-5.6 Luna" model, and it shows ads (as does Go at $8). Codex (CLI, cloud and IDE) is included on all ChatGPT plans, including Free and Go, with agentic limits that depend on the plan. Plus ($20) is the cheapest ad-free tier with a real Codex allowance. Pulse is still a Pro-oriented feature and of little use for learning.

### Cited Findings
- **Study Mode:** launched Jul 29, 2025 for logged-in Free, Plus, Pro and Team users. It guides with Socratic questions, scaffolding and knowledge checks instead of giving a ready answer. — [TechCrunch](https://techcrunch.com/2025/07/29/openai-launches-study-mode-in-chatgpt)
- I found no separate Study Mode limits for Free or Plus. It follows the general message limits. — [Dupple](https://dupple.com/learn/chatgpt-for-students)
- **Free tier (Engadget, Aug 2026):**
  - From the week of Aug 10, 2026, Free and Go get unlimited text chats, with separate caps on image generation and file uploads.
  - Free can use only **GPT-5.6 Luna** and a single reasoning mode; larger GPT-5.6 models need a subscription.
  - Earlier 2026 sources described ~10 messages / 5 h on GPT-5.5 Instant followed by a fallback to a mini model, which shows how often these limits change.
  — [Engadget](https://engadget.com/2234173/chatgpt-free-features-2026); [CometAPI](https://www.cometapi.com/chatgpt-pricing-2026-free-vs-go-vs-plus-vs-pro/)
- **Ads and Go:** ads on Free and Go started in Feb 2026. Go (~$8) is a cheaper tier available worldwide. Plus and above have no ads. — [AlternativeTo, Jan 2026](https://alternativeto.net/news/2026/1/openai-is-officially-bringing-ads-to-chatgpt-and-announcing-a-cheaper-go-tier-worldwide); [CometAPI](https://www.cometapi.com/chatgpt-pricing-2026-free-vs-go-vs-plus-vs-pro/)
- **Codex:** OpenAI's help center says Codex is included in all ChatGPT plans (Free, Go, Plus, Pro, Business, Edu, Enterprise). Usage counts toward an "agentic usage limit" and depends on task size. Exact figures are on the developer pricing page. — [OpenAI Help: Using Codex with your ChatGPT plan](https://help.openai.com/en/articles/11369540); [Codex pricing](https://developers.openai.com/codex/pricing)
- On Plus, a rolling **5-hour cap** on Codex returned from Aug 25, 2026, on top of the weekly quota. It had been removed in mid-July. Pro tiers ($100 and $200) are not subject to it. — [iThinkDiff](https://www.ithinkdiff.com/openai-codex-five-hour-limit/); [Pillitteri](https://pasqualepillitteri.it/en/news/12697/openai-5-hour-codex-chatgpt-work-limit-plus)
- Exact window limits are not published. Community estimates for Plus are ~45–225 messages per window, and complex refactors can drain a Plus window in 2–4 tasks. — [Hongkiat](https://www.hongkiat.com/blog/?p=74259)
- **Pulse:** preview launched Sep 25, 2025 for Pro on mobile, with Plus promised later. As of Feb 2026 the Plus rollout had not started. — [Thurrott](https://www.thurrott.com/a-i/openai-a-i/327299/openai-launches-chatgpt-pulse-in-preview); [SentiSight](https://www.sentisight.ai/when-will-chatgpt-pulse-be-available-for-plus-and-free-users/)

### Inferences
- Use **Study Mode** on Free for daily theory questions and concept checks. Free now has no hard cap on text, but the model is weak.
- **Codex CLI on Free or Go** is a zero-cost way to try an agentic CLI. Serious agentic project work needs Plus (and the 5-hour window can run out fast).
- **Advanced Voice** is potentially useful for practising explaining concepts aloud (rubber-ducking or mock interviews), but I did not verify its 2026 limits (see Gaps).
- **Pulse** has low value for a learner's budget.

### Gaps
- No fresh 2026 data on **Advanced Voice Mode** and **canvas** limits for Free versus Plus; the chatgpt.com/pricing and openai.com pages returned 403.
- Exact Codex limits for Free and Go are not published.
- Whether Pulse reached Plus by Oct 2026 is unconfirmed.

## Q4. GitHub (Copilot Free/Student/Pro, coding agent, Student Developer Pack, Codespaces, GitHub Skills)

### Takeaway
Copilot now runs on **AI credits** instead of premium requests. Copilot Free gives 2,000 completions/month, a small credit allowance and Auto model selection only, with no coding agent. The **Copilot Student** plan (free for verified students) includes the cloud coding agent, but only with Auto model selection. Signups for Student, Pro and Pro+ were paused from Apr 20 to about Jun 17, 2026. Codespaces gives 120 core-hours/month free (about 60 h on 2 cores).

### Cited Findings
- **Plans (official docs, current):**

  | Plan | Price | AI credits | Model choice | Cloud coding agent |
  |---|---|---|---|---|
  | Copilot Free | $0 | Unspecified allowance; 2,000 completions/month | Auto only | No |
  | Copilot Student | $0 for verified students | Unspecified allowance | Auto only | Yes |
  | Copilot Pro | $10/mo | 1,500 (1,000 base + 500 flex) | — | Yes |
  | Pro+ | $39/mo | 7,000 | — | Yes |
  | Max | $100/mo | 20,000 | — | Yes |

  "Verified teachers, and maintainers of popular open source projects may be eligible for free access to Copilot Pro." — [GitHub Docs: Copilot plans](https://docs.github.com/en/copilot/get-started/plans)
- **Apr 20, 2026 changelog:**
  - New signups for Student, Pro and Pro+ were paused "to prioritize service quality for existing paying customers". Copilot Free stayed open.
  - Opus models were removed from Pro. Opus 4.7 remains on Pro+.
  - Refunds were available until May 20.
  — [GitHub Changelog 2026-04-20](https://github.blog/changelog/2026-04-20-changes-to-github-copilot-plans-for-individuals/)
- Signups gradually reopened from **Jun 17, 2026**, alongside a new $100 Max tier (secondary sources; I did not open the reopening changelog itself). — [Tech-Insider](https://tech-insider.org/ie/github-copilot-signup-freeze-2026/); [Layer3Labs, Oct 1, 2026](https://www.layer3labs.io/guides/github-copilot-student)
- Mar 2026: free student access moved to a separate **Copilot Student** plan. GPT-5.4, Claude Opus and Claude Sonnet can no longer be selected manually there; they are reachable only through Auto. One third-party source cites 200 AI credits/month plus unlimited completions for Student. — [Roboin](https://roboin.io/article/en/2026/03/13/github-copilot-student-plan-removes-direct-access-to-premium-models/); [Layer3Labs](https://www.layer3labs.io/guides/github-copilot-student)
- Older third-party guides still quote the pre-credits model: Free with 2,000 completions, 50 premium requests and ~50 chats per month. — [fast.io](https://fast.io/resources/github-copilot-free-access/)
- **Codespaces:** personal GitHub Free accounts get 120 core-hours and 15 GB-month per month; GitHub Pro gets 180 core-hours and 20 GB. Core-hours are multiplied by core count (2-core → ~60 h). Without a payment method, Codespaces is blocked once the quota runs out. GitHub says the quota is for open source and side projects. — [GitHub Docs: Codespaces billing](https://docs.github.com/en/billing/concepts/product-billing/github-codespaces)
- **Student Developer Pack:** includes Codespaces (described as "Pro level", likely 180 h / 20 GB, unconfirmed officially), JetBrains, Azure credits and more. — [GitHub Education Pack](https://education.github.com/pack); [Capital & Compute 2026](https://capitalandcompute.net/blog/github-student-developer-pack-2026/)

### Inferences
- A learner with student status should take **Copilot Student** (free cloud agent and unlimited completions) plus the **Student Pack**.
- Without student status, **Copilot Free** is enough for completions in VS Code. Beginners are better off with completions **turned off** in the first months so they build typing and recall skills. This is a pedagogical inference, not a source claim.
- **Codespaces** at 60 h/month on 2 cores gives a full cloud dev environment for free, which helps if the learner's own machine is weak.

### Gaps
- Exact AI-credit allowances for Free and Student are not stated in the official docs.
- The exact date of the switch to AI credits is not confirmed by a primary source.
- No 2026 data found on **GitHub Skills** courses; they likely still exist as free interactive courses at skills.github.com, but this is unverified.

## Q5. Manus (agentic research and action agent)

### Takeaway
Manus is a general-purpose autonomous agent for multi-step tasks such as research, browsing, building reports and small sites. Its credit-based pricing is expensive and unstable: credits burn fast and the free tier changed in 2026. Its corporate status is turbulent: Meta bought it in Dec 2025, the deal was reportedly blocked by China, and Manus reportedly became independent again in Aug 2026. For a learner it is a secondary tool.

### Cited Findings
- Meta announced the acquisition on Dec 29, 2025 for about $2 billion. — [Pillitteri](https://pasqualepillitteri.it/en/news/396/manus-ai-autonomous-agent-meta); [Naoma, May 2026](https://naoma.ai/articles/what-is-manus-ai)
- Reports say China's NDRC blocked the deal on Apr 27, 2026, and that on Aug 11, 2026 Manus said it had resumed operating as an independent company. These details come from aggregated search coverage and should be treated as **low confidence**. — [PricingSaaS](https://pricingsaas.com/companies/manus); [Preuve review](https://preuve.ai/blog/manus-ai-review)
- Pricing: older sources describe Free at $0 with 300 credits and daily refresh. An Aug 2026 report says the official page shows only paid tiers ($20 / $40 / $200), while an Oct 2026 guide describes a free plan with 1,500 credits/month on the Lite model only. Credits do not roll over, and reviews complain they "burn fast". — [Moclaw](https://moclaw.ai/blog/manus-ai-free); [Preuve](https://preuve.ai/blog/manus-ai-review); [NoCode MBA](https://www.nocode.mba/articles/manus-ai-pricing)

### Inferences
- For a self-taught programmer, Manus is useful for one-off research tasks, such as "compare 10 courses or frameworks and build a table" or "collect job requirements for a role". It does not teach programming.
- It overlaps with free alternatives (Gemini Deep Research, ChatGPT agent and deep research, NotebookLM Deep Research), so a paid plan is not recommended.

### Gaps
- No access to the official manus.im pricing page; the free tier's status is unclear.

## Q6. NVIDIA build.nvidia.com (NIM API catalog)

### Takeaway
build.nvidia.com gives free, OpenAI-compatible access to a large catalog of open models (Llama, Nemotron, DeepSeek, Qwen, Kimi, Mistral and others) through the free NVIDIA Developer Program. It is "for prototyping" only and limited to about 40 RPM, with no way to raise the limit on the free tier. It is a good fit for a learner building their first LLM apps and agents and for comparing open models.

### Cited Findings
- NIM FAQ: Developer Program members can use the NIM API endpoints "for prototyping, research, development and testing purposes only", without enterprise features or support, for as long as their membership lasts. — [NVIDIA NIM FAQ (forum)](https://forums.developer.nvidia.com/t/nvidia-nim-faq/300317)
- The rate limit is about **40 RPM**, confirmed by moderators. There is "no official way to circumvent this rate limit or to receive a rate limit increase" on the free tier, and higher limits require a paid deployment. — [NVIDIA forum](https://forums.developer.nvidia.com/t/api-rate-limit-increase-is-not-granted-by-requesting-it-here/368420); [NVIDIA forum thread](https://forums.developer.nvidia.com/t/request-for-nvidia-build-api-rate-limit-increase-40-rpm-200-rpm/378450)
- Credits: one 2026 article says the credit system was retired in early 2025 and free use now runs on rate limits only. Forum threads from 2026 still mention 1,000 credits, so this is a **conflict**. — [Medium (Vignaraj)](https://medium.com/@vignarajj/beyond-the-hype-supercharging-my-local-development-workflow-with-nvidia-nim-and-opencode-free-6ff12d6f851e); [NVIDIA forum (1,000→5,000 credits request)](https://forums.developer.nvidia.com/t/credit-rate-limit-increase-request-1-000-5-000-credits-40-200-rpm/380932)
- The OpenAI-compatible endpoint is `integrate.api.nvidia.com/v1`. The catalog includes Llama, Mistral/Mixtral, Nemotron, DeepSeek, Qwen, Kimi K2 and others, with 80 to 160+ models depending on the source. Limits vary by model and current load, and the tier is not for production. — [DEV Community](https://dev.to/creeta/two-lines-swap-openai-for-160-free-nvidia-hosted-models-njg); [MindStudio](https://www.mindstudio.ai/blog/nvidia-free-api-access-80-ai-models)

### Inferences
- It is ideal for the "learn to build LLM apps" stage: swap `base_url` in the OpenAI SDK and try RAG, tool calling and agents on large open models (DeepSeek, Qwen, Nemotron) without paying.
- 40 RPM is plenty for learning experiments but not enough for agentic coding tools with many calls (OpenCode and similar), which is why the forums are full of limit-increase requests.

### Gaps
- No official NVIDIA page with the current list of models and limits per model.

## Q7. OpenRouter (unified API, free models)

### Takeaway
OpenRouter is a single OpenAI-compatible API to hundreds of models from many providers. `:free` models are limited to 20 RPM and **50 requests/day** if the account has bought less than $10 of credits in total, or **1,000/day** after a one-time purchase of at least $10. That $10 unlock is the cheapest way to get a stable free sandbox across many models.

### Cited Findings
- Official limits for `:free` models: 20 requests/minute. The daily cap is 50 requests/day with less than 10 credits purchased and 1,000 requests/day with at least 10 credits purchased. A negative balance can block even free models (402 errors). Cloudflare DDoS protection blocks requests that "dramatically exceed reasonable usage". — [OpenRouter docs: Limits](https://openrouter.ai/docs/api-reference/limits)
- The $10 unlock is said to be permanent even if the balance later drops to zero. On paid models, 429 errors usually come from the provider, not the gateway. — [TrueFoundry](https://www.truefoundry.com/de/blog/openrouter-rate-limits-your-free-tier-depends-on-what-youve-already-paid); [Pinggy](https://pinggy.io/blog/free_ai_model_apis_unlimited_tokens_openrouter/)

### Inferences
- OpenRouter is the best "learning lab" for comparing models (cost and quality) through a single API and SDK. It teaches provider routing, fallbacks, and reading token costs.
- Plan: $10 once → 1,000 free requests/day, plus cheap paid models for "real" tests.

### Gaps
- The current list of `:free` models changes constantly; I did not take a 2026 snapshot.

## Q8. Other free learning tools (CS50 Duck, Exercism, Cursor, Windsurf, Ollama)

### Takeaway
The **CS50 Duck** (cs50.ai) is the best-documented pedagogical AI tutor: designed not to hand out answers and grounded in course materials. **Exercism** is free practice with volunteer human mentors. Cursor and Windsurf free tiers are small. **Ollama** allows fully local models and has a free cloud tier with large open coding models (qwen3-coder, gpt-oss).

### Cited Findings
- **CS50 Duck:**
  - An AI "rubber duck debugger" at CS50.ai, built on Azure and OpenAI with a vector database of course materials.
  - CS50 allows it where ChatGPT is banned.
  - Usage: 201k students and teachers, ~35k prompts/day.
  — [CS50 AP 2026 notes: AI](https://cs50.harvard.edu/ap/2026/curriculum/x/notes/ai/)
- The Duck is available in CS50x on edX, "open to anyone online", and enrollment is free (2024 post). — [CS50x Telegram](https://t.me/s/cs50x?q=%23AI)
- **Exercism:** "100% free, forever". It offers language tracks (79+ languages), automated analysis and mentoring by volunteer mentors. A 2026 review calls it "not for beginners", and Exercism points beginners to jiki.io. — [Exercism mentoring docs](https://exercism.org/docs/mentoring); [freetier.co](https://freetier.co/directory/products/exercism); [Trustpilot](https://ch.trustpilot.com/review/exercism.org)
- **Cursor:** the free tier reportedly gives ~2,000 Tab completions and ~50 slow premium requests per month (community figures), with no Auto. Sources disagree on whether "Hobby" is free or a $10 tier. — [Verdent](https://www.verdent.ai/ja/guides/cursor-free-trial-free-plan); [AgentDeals](https://agentdeals.dev/compare/cursor-vs-windsurf)
- **Windsurf:** the free tier has daily quotas for Cascade, completions and chat; credits were replaced by quotas in Mar 2026. No figures found. — [AgentDeals](https://agentdeals.dev/compare/cursor-vs-windsurf)
- **Ollama:**
  - Local models need no account.
  - Cloud models (`:cloud` tag) have a free tier with "generous limits" and a 5-hour coding session window.
  - The free list reportedly includes gpt-oss:120b, qwen3-coder:480b and deepseek-v3.1.
  - Limits are metered by GPU time (5-hour session window plus a weekly cap).
  — [Ollama blog](https://registry.ollama.ai/blog/launch); [DevToolHub](https://devtoolhub.com/ollama-cloud-free-vs-pro-limits-pricing-2026/); [FreeLLM](https://freellm.net/providers/ollama-cloud)
- Ollama can serve as a backend for Claude Code (local or cloud models) to run an agentic CLI for free. — [Towards Data Science](https://towardsdatascience.com/run-claude-code-for-free-with-local-and-cloud-models-from-ollama/)

### Inferences
- The **CS50 Duck** is the best choice for CS fundamentals in the early months. It is "tutor by design", so it does not need disciplined prompting to avoid spoon-feeding.
- **Ollama locally** is valuable for understanding how LLMs work (quantization, context, tokens) and for offline or private practice. **Ollama Cloud free** gives a free agentic coding backend.
- **Cursor and Windsurf free** add little on top of Copilot Free plus Claude or Gemini. They are not a priority.

### Gaps
- Current cs50.ai access rules (whether you need a GitHub login or course enrollment) are unverified.
- I found no evidence that Exercism has built-in AI hints in 2026.
- No official Cursor or Windsurf pricing figures (only third-party sources).

## Q9. Tutor-style prompting best practices (Socratic, "don't give me the answer", Mollick, official guidance)

### Takeaway
All three big vendors have built a "tutor mode" into their products: Claude Learning mode, ChatGPT Study Mode and Gemini Guided Learning. In practice these are system instructions for Socratic guidance. The same can be done by hand with the Mollicks' tutor prompts (CC BY 4.0) or, in Claude Code, with a custom output style.

### Cited Findings
- **The Mollicks' tutor prompt structure:**
  - An upbeat tutor who explains and asks questions, **one question at a time**.
  - First it finds out what the learner wants to study, then their level, then their prior knowledge.
  - It tailors explanations to that and wraps up once the learner shows they understand.
  — [Northwestern: The Tutor](https://ai.northwestern.edu/education/the-tutor.html)
- The More Useful Things library (Ethan and Lilach Mollick) has sections for Instructor Aids and Student Exercises. Prompts are licensed CC BY 4.0, so attribution is required. — [W&L Academic Technologies](https://academic.wlu.edu/2024/03/06/the-generative-ai-prompt-library-that-every-educator-and-student-needs/)
- The tutor prompt originally comes from "Assigning AI: Seven Useful Ways of Using AI in Class" (One Useful Thing, Jun 12, 2023). — [Northwestern](https://ai.northwestern.edu/education/the-tutor.html)
- Anthropic's official approach is the Learning style in Claude Code: the model does routine work, leaves `TODO(human)` for decisions with more than one valid approach, waits, then gives feedback. This pattern can be copied into a custom output style. — [Claude Code docs](https://code.claude.com/docs/en/output-styles)
- ChatGPT Study Mode uses Socratic questions, scaffolding and knowledge checks. — [TechCrunch](https://techcrunch.com/2025/07/29/openai-launches-study-mode-in-chatgpt)
- Gemini Guided Learning uses step-by-step guidance, visuals and quizzes, powered by LearnLM. — [TechCrunch](https://techcrunch.com/2025/08/06/google-takes-on-chatgpts-study-mode-with-new-guided-learning-tool-in-gemini/); [ForkLog](https://forklog.com/en/google-transforms-gemini-into-an-ai-tutor/)
- Anthropic's AI Fluency 4D framework (Delegation, Description, Discernment, Diligence) frames AI collaboration while keeping independent skills. — [Coursera](https://www.coursera.org/learn/ai-fluency-for-students)

### Inferences
- A practical "don't give me the answer" template, synthesized from the sources:
  1. State your level and goal.
  2. Ask the AI to quiz you on prior knowledge first.
  3. One question at a time.
  4. Hints in escalating levels (hint → pseudocode → partial code), with **no full solution until you ask explicitly**.
  5. After a solution, ask the AI to have you explain the code back.
  6. End with a 3-question check.
- Built-in modes (Study, Guided Learning, Learning) are more convenient than hand-written prompts. For code, though, Claude Code's `TODO(human)` mechanic is the only one that **makes** the learner write code inside a real repository.

### Gaps
- I could not open the original More Useful Things prompt text or the OpenAI and Google official posts with study-mode design details (403 or not in results).

## Q10. Comparison table and recommended allocation to learning tasks

### Takeaway
Optimal allocation for a low budget:
- **Theory and concepts:** ChatGPT Study Mode, Gemini Guided Learning, Claude Learning mode. All are free.
- **Learning from docs and books, plus spaced repetition:** NotebookLM. Free.
- **CS fundamentals with a strict tutor:** CS50 Duck. Free.
- **Project code with forced practice:** Claude Code, Learning style. Pro at $20.
- **Completions and agent PRs:** Copilot Free or Student, plus Jules (15 free tasks/day).
- **Building LLM apps:** OpenRouter ($10 unlock), NVIDIA build (free, 40 RPM), AI Studio free tier, Ollama.

### Cited Findings
Every cell is backed by the sources in Q1–Q8.

| Tool | Best for (learning) | Learning-specific features | Free tier (as of Oct 2026) | Cheapest paid | Confidence / caveats |
|---|---|---|---|---|---|
| Claude (claude.ai) | Socratic explanations, interactive Artifacts | Learning mode (all users since Aug 2025); Projects | Sonnet/Haiku, 5 Projects, Artifacts ([pricing](https://claude.com/pricing)) | Pro $20 ($17 annual) | High (official) |
| Claude Code | Projects with forced practice | Learning style (`TODO(human)`), Explanatory (`Insight`), custom styles ([docs](https://code.claude.com/docs/en/output-styles)) | None (Pro and up) | Pro $20; Max $100+ | High (official) |
| ChatGPT | Daily theory Q&A, concept checks | Study Mode (all plans, Jul 2025) ([TC](https://techcrunch.com/2025/07/29/openai-launches-study-mode-in-chatgpt)) | Unlimited text on GPT-5.6 Luna, ads ([Engadget](https://engadget.com/2234173/chatgpt-free-features-2026)) | Go ~$8 (ads); Plus $20 | Medium (limits change often) |
| Codex (OpenAI) | Agentic CLI and cloud on projects | — | Included on Free and Go with small limits ([OpenAI Help](https://help.openai.com/en/articles/11369540)) | Plus $20 (5-hour window + weekly cap) | Medium |
| Gemini app | Visual, step-by-step explanations | Guided Learning (LearnLM) ([TC](https://techcrunch.com/2025/08/06/google-takes-on-chatgpts-study-mode-with-new-guided-learning-tool-in-gemini/)) | Yes | AI Plus / AI Pro $19.99. US students: AI Pro free for 12 mo (redeem by Dec 31, 2026) ([MacRumors](https://macrumors.com/2026/08/19/students-free-year-google-ai-pro)) | High |
| NotebookLM | Learning from docs and books; spaced repetition | Flashcards, quizzes, study guides, Audio/Video Overviews, mind maps, source citations ([Google Edu](https://edu.google.com/intl/ALL_us/ai-notebooklm)) | ~50 chats/day, 3 audio/day, 100 notebooks (third-party) | Via Google AI plans | Medium on limits |
| Google AI Studio / Gemini API | First LLM API projects | — | Free tier; 3.5 Flash RPD disputed (20 vs 1,500); Pro not free ([Tilnote](https://tilnote.io/pages/6a51b3398d9a59d14c1c174c)) | Pay-as-you-go | Low on figures |
| Gemini CLI → Antigravity CLI / IDE | Agentic coding | — | Gemini CLI ended for free users Jun 18, 2026 ([geminicli](https://geminicli.com/docs/resources/quota-and-pricing/)); Antigravity has weekly caps and Gemini-only free models from Nov 2, 2026 ([Preuve](https://preuve.ai/blog/antigravity-review)) | AI Pro $19.99 | Medium |
| Jules | Async agent, practising PR review | — | 15 tasks/day, 3 concurrent ([TC](https://techcrunch.com/2025/08/06/googles-ai-coding-agent-jules-is-now-out-of-beta)) | AI Pro (5x) | Medium (2025 data) |
| Firebase Studio | Not recommended | — | Shuts down Mar 22, 2027 ([Storyboard18](https://www.storyboard18.com/digital/google-to-shut-firebase-studio-in-2027-shifts-focus-to-ai-studio-and-antigravity-92922.htm)) | — | High |
| GitHub Copilot | IDE completions; cloud agent PRs | — | Free: 2,000 completions, Auto only, no agent. Student: free with agent, Auto only ([Docs](https://docs.github.com/en/copilot/get-started/plans)) | Pro $10 (1,500 credits) | High (official) |
| Codespaces | Cloud dev environment | — | 120 core-h (~60 h on 2 cores) + 15 GB/mo ([Docs](https://docs.github.com/en/billing/concepts/product-billing/github-codespaces)) | Pay-as-you-go | High |
| Manus | One-off research and agent tasks | — | Unclear in 2026 (credits) ([Moclaw](https://moclaw.ai/blog/manus-ai-free)) | $20 | Low (ownership and pricing turbulent) |
| NVIDIA build (NIM) | Testing open models; LLM app prototypes | — | Free for prototyping, ~40 RPM, no increase ([forum](https://forums.developer.nvidia.com/t/api-rate-limit-increase-is-not-granted-by-requesting-it-here/368420)) | Paid deployment | Medium (unofficial figures) |
| OpenRouter | Unified API, model comparison | — | `:free` models: 20 RPM; 50/day, or 1,000/day after ≥$10 purchased ([docs](https://openrouter.ai/docs/api-reference/limits)) | $10 one-time unlock | High (official) |
| CS50 Duck | CS fundamentals, debugging without spoilers | Tutor by design, grounded in course materials ([CS50](https://cs50.harvard.edu/ap/2026/curriculum/x/notes/ai/)) | Free (with CS50x) | — | Medium on access rules |
| Exercism | Practice and human code review | Volunteer mentors, automated analysis ([Exercism](https://exercism.org/docs/mentoring)) | 100% free | Insiders (donation) | Medium |
| Cursor / Windsurf | Alternative AI IDEs | — | ~2,000 completions + ~50 slow requests (Cursor, community figures); Windsurf has daily quotas ([AgentDeals](https://agentdeals.dev/compare/cursor-vs-windsurf)) | ~$10–20 | Low |
| Ollama (local / cloud) | Offline models; understanding LLMs; free agent backend | — | Local is free; Cloud free has 5-hour and weekly caps (gpt-oss, qwen3-coder) ([DevToolHub](https://devtoolhub.com/ollama-cloud-free-vs-pro-limits-pricing-2026/)) | ~$20 (unconfirmed) | Medium |

### Inferences
**Allocation by learning task:**
1. **Learning a new concept or theory:** Gemini Guided Learning, ChatGPT Study Mode or Claude Learning mode. All are free, so pick by preference. Gemini gives the most visuals.
2. **Learning from documentation, books or a course:** NotebookLM, including quizzes and flashcards for repetition and Audio Overviews for passive listening.
3. **CS fundamentals (CS50 or similar):** the CS50 Duck as the main tutor.
4. **Practice on katas:** Exercism (human mentors), with AI only for hints in Study or Learning mode.
5. **Writing project code while still learning:** Claude Code with the Learning style (Pro $20 is the main recommended spend). Switch to Explanatory when you need to understand someone else's codebase.
6. **Practising agent workflows and code review of AI PRs:** Jules (15 free tasks/day), the Copilot cloud agent (Student plan), Codex on the Free or Plus tier.
7. **Building LLM apps (RAG, agents, tool calling):** OpenRouter ($10 unlock → 1,000 free requests/day), NVIDIA build (free open models, 40 RPM), Gemini API free tier, Ollama local.
8. **Environment:** Codespaces (60 h/month free) or local setup. Antigravity IDE as a free agentic IDE, with Gemini-only free models from Nov 2, 2026.
9. **Research (courses, frameworks, the job market):** Gemini, ChatGPT or NotebookLM Deep Research first. Manus only for occasional one-off tasks.

**Budget scenarios:**
- **$0:** Gemini, ChatGPT and Claude free tiers + NotebookLM + CS50 Duck + Exercism + Copilot Free + Jules + NVIDIA build + OpenRouter (50/day) + Ollama.
- **~$20/mo:** add Claude Pro for Claude Code Learning style, plus a one-time $10 on OpenRouter.
- **Student:** free Copilot Student, the GitHub Student Pack, and Google AI Pro (US) or AI Plus (other countries) for 12 months.

### Gaps
- Many exact quotas (AI Studio, Antigravity, NotebookLM, Codex Free, Copilot Free AI credits) are not published officially or conflict between sources. Re-check them on the official pages before writing a final plan.
- I did not verify regional availability (for example, the user's country) for Google's student offers and Copilot Student.
