# AI coding assistants and learning, skill formation, and productivity: empirical evidence 2023–2026

Research date: 26 Oct 2026. Every claim has an inline source. Items not verified in this session are marked **[unverified]** or listed under Gaps.

---

## 1. METR RCT on experienced open-source developers (July 2025) and the 2026 follow-up

### Takeaway
In early 2025, experienced maintainers working on their own large repositories took **19% longer** with AI tools, but believed AI had made them about **20% faster**. METR's February 2026 follow-up points to a likely speedup with late-2025 tools (central estimates −18% and −4% time change). Both confidence intervals include zero, and METR calls the data "unreliable" because developers withheld tasks they did not want to do without AI. The perception gap held up more firmly than any single speed number.

### Cited Findings
- **Original study design:** 16 experienced OSS developers worked 246 real issues (bug fixes, features, refactors) of about 2 hours each. The repos averaged 22k+ stars and over 1M lines of code, and each developer had contributed to theirs for years. Each issue was randomly assigned to AI-allowed or AI-disallowed. The main tool was Cursor Pro with Claude 3.5/3.7 Sonnet. — [METR blog, 10 Jul 2025](https://metr.org/blog/2025-07-10-early-2025-ai-experienced-os-dev-study/)
- **Main result:** with AI allowed, issues took **19% longer**. Developers had forecast a 24% speedup beforehand, and afterwards still believed AI had sped them up about 20%. Experts also forecast a speedup. — [METR blog](https://metr.org/blog/2025-07-10-early-2025-ai-experienced-os-dev-study/)
- **95% CI** for the original slowdown: +2% to +39% longer. — [METR uplift update, 24 Feb 2026](https://metr.org/blog/2026-02-24-uplift-update/)
- METR examined 20 candidate factors and found 5 likely contributors. It ruled out experimental artifacts: non-frontier models, assignment non-compliance, differential dropout, and PR quality differences. — [METR blog](https://metr.org/blog/2025-07-10-early-2025-ai-experienced-os-dev-study/)
- **Limitations stated by METR:**
  - The sample is small (n=16).
  - Results do not generalize to less experienced developers or unfamiliar codebases.
  - Most developers had only a few dozen hours of Cursor experience, so learning effects beyond about 50 hours cannot be ruled out.
  - Times were self-reported.
  - The results describe early-2025 tools.
  — [METR blog](https://metr.org/blog/2025-07-10-early-2025-ai-experienced-os-dev-study/)
- **2026 follow-up design:** the new study started August 2025, with 57 developers (10 returning, 47 new), 143 repos and 800+ tasks. Median OSS experience was 10 years. Pay fell to $50/h from $150/h. — [METR uplift update](https://metr.org/blog/2026-02-24-uplift-update/)
- **2026 estimates:** returning developers −18% time (CI −38% to +9%); new developers −4% (CI −15% to +9%). These use the same convention as the original +19% (positive = longer), so negative means faster. Both CIs cross zero. — [METR uplift update](https://metr.org/blog/2026-02-24-uplift-update/). Some secondary coverage misstates the sign or calls this a "reversal". — [birchtree.me](https://birchtree.me/blog/an-update-from-the-study-that-said-devs-were-actually-slower-with-coding-agents/); [particula.tech](https://particula.tech/blog/metr-reversed-19-percent-slower-ai-coding-study)
- **Selection problems in 2026:**
  - 30–50% of surveyed developers said they had not submitted some tasks because they did not want to do them without AI.
  - More developers refused to participate at all.
  - Some developers rarely completed tasks in the AI-disallowed arm; one completed none.
  - Task mix shifted toward AI strengths.
  - Time tracking broke down when developers ran agents concurrently with other work.

  METR concluded developers are "probably more sped up" in early 2026 than in early 2025, but its data is "only very weak evidence" for the size of that increase. It treats the estimates as likely lower bounds. — [METR uplift update](https://metr.org/blog/2026-02-24-uplift-update/)
- **Redesign:** METR plans shorter high-compliance experiments, fixed-task designs, developer-level randomization, observational transcript data and time-use surveys. A separate METR survey of 349 technical workers found a median **self-reported** 1.4×–2× change in the value of their work from AI. — [METR uplift update](https://metr.org/blog/2026-02-24-uplift-update/)

### Inferences
- Self-reports of AI speedup are unreliable in both directions. In the 2025 study, perceived speed had the opposite sign to measured speed. Learners should measure their own outcomes (time-to-correct-solution, review findings) rather than trust how productive they feel.
- AI helps least where developers already have deep context on large, mature codebases with high quality bars. In 2026 the evidence is too noisy to set a firm number for any setting.
- That developers refuse to work without AI is itself a signal of dependence. A 2026 study could not get a clean control group.

### Gaps
- The five contributing factors from the 2025 paper (arXiv 2507.09089), such as over-optimism, repo familiarity, repo size and complexity, low AI reliability, and implicit context, were not re-verified in this session. The paper's figures that developers accepted under 44% of AI generations and spent about 9% of time reviewing AI output are also **[unverified]**.
- As of Oct 2026, no redesigned METR RCT result was found.

---

## 2. Anthropic research on AI and coding skill formation, plus "learning mode" products

### Takeaway
In Anthropic's January 2026 RCT, 52 mostly junior engineers learned the unfamiliar Trio async library. Those with AI assistance scored **17% lower** on a comprehension quiz (50% vs 67%, Cohen's d = 0.738, p = 0.01) and saved no significant time. The largest gap was in **debugging**. How people used the AI mattered: those who asked conceptual questions or demanded explanations kept their learning, while those who delegated lost it.

### Cited Findings
- **Paper:** Judy Hanwen Shen and Alex Tamkin, "How AI assistance impacts the formation of coding skills", published 29 Jan 2026, arXiv 2601.20245. — [Anthropic Research](https://www.anthropic.com/research/AI-assistance-coding-skills); [The Decoder](https://the-decoder.com/ai-coding-tools-hurt-learning-unless-you-ask-why-anthropic-study-finds/)
- **Design:** RCT with 52 mostly junior engineers. All had used Python weekly for over a year, were somewhat familiar with AI assistants, and had never used Trio. The session had four stages: a 10-minute warm-up, a 35-minute task implementing two Trio features, a 25-minute quiz, and a survey. The AI group had a sidebar chat assistant during the task only. — [Anthropic Research](https://www.anthropic.com/research/AI-assistance-coding-skills)
- **Results:** the quiz averaged **50% with AI vs 67% by hand** (17 points lower; d = 0.738, p = 0.01). The largest gap was on debugging questions. The AI group finished only about 2 minutes faster, which was not significant (p = 0.391). — [Anthropic Research](https://www.anthropic.com/research/AI-assistance-coding-skills)
- **Low-scoring interaction patterns (quiz under 40%):**
  - AI delegation (n=4): about 19.5 min, 39%.
  - Progressive AI reliance (n=4): started by asking questions, then handed over all the code. About 22 min, 35%.
  - Iterative AI debugging (n=4): used AI to debug or verify code. About 31 min, 24%.

  — [Anthropic Research](https://www.anthropic.com/research/AI-assistance-coding-skills)
- **High-scoring patterns (quiz 65% or higher):**
  - Generation-then-comprehension (n=2): generated code, then asked follow-up questions. About 24 min, 86%.
  - Hybrid code-explanation (n=3): asked for code together with explanations. About 24 min, 68%.
  - Conceptual inquiry (n=7): asked only conceptual questions and fixed errors themselves. About 22 min, 65%.

  — [Anthropic Research](https://www.anthropic.com/research/AI-assistance-coding-skills)
- **Authors' conclusions:** "Cognitive effort—and even getting painfully stuck—is likely important for fostering mastery." AI-enhanced productivity is "not a shortcut to competence." — [Anthropic Research](https://www.anthropic.com/research/AI-assistance-coding-skills); [InfoQ](https://infoq.com/news/2026/02/ai-coding-skill-formation/)
- **Limitations:**
  - The sample is small, and the pattern clusters have n=2–7, so they are not causal.
  - The quiz came immediately after the task, so retention and transfer were not measured.
  - The tool was chat-based. The authors expect agentic tools like Claude Code could have *more* pronounced effects.

  — [Anthropic Research](https://www.anthropic.com/research/AI-assistance-coding-skills)
- **Anthropic Education Report (8 Apr 2025):** analyzed 574,740 student-relevant conversations from university-linked Claude.ai accounts.
  - Four interaction styles each covered about 23–29% of conversations: Direct or Collaborative, crossed with Problem Solving or Output Creation.
  - About **47% of conversations were "Direct"**, seeking answers or content with minimal engagement.
  - Claude's responses were classified as Creating (39.8%) and Analyzing (30.2%), the upper levels of Bloom's taxonomy. This raises concern that students offload higher-order thinking.
  - Computer science made up 36.8–38.6% of conversations (the report gives both figures) but only 5.4% of US bachelor's degrees.

  — [Anthropic Education Report](https://www.anthropic.com/news/anthropic-education-report-how-university-students-use-claude)
- **Claude for Education "Learning mode" (April 2025):** a Socratic mode inside Projects. It asks "How would you approach this problem?" and "What evidence supports your conclusion?" instead of giving answers. — [Anthropic: Introducing Claude for Education](https://www.anthropic.com/news/introducing-claude-for-education); [Engadget](https://engadget.com/ai/claudes-new-learning-mode-will-prompt-students-to-answer-questions-on-their-own-172057828.html)
- **Claude Code output styles:**
  - *Explanatory* adds "Insights" about implementation choices and codebase patterns.
  - *Learning* also asks the user to write small, strategic pieces of code, marked with `TODO(human)`.
  - Both produce longer outputs. They are set via `/config`.

  — [Claude Code docs: Output styles](https://code.claude.com/docs/en/output-styles). The Anthropic skill study points to these and to ChatGPT Study Mode as learning-oriented modes. — [Anthropic Research](https://www.anthropic.com/research/AI-assistance-coding-skills)

### Inferences
- The low-scoring patterns all share one feature: the AI did the **diagnosis**. Debugging was both the most common way people delegated and the most damaged skill.
- Conceptual inquiry reached nearly the control group's score (65% vs 67%) and was among the faster patterns. Learners appear to lose little speed by restricting AI to explanations.
- Learning and explanatory modes exist as products. However, no published RCT was found showing that Claude's Learning mode or output style improves learning outcomes (see Gaps).

### Gaps
- No controlled evaluation of Claude Learning mode, Claude Code Learning/Explanatory styles, or ChatGPT Study Mode on learning outcomes was found.
- No delayed-retention follow-up to the Trio study was found.

---

## 3. Cognitive offloading and critical thinking: MSR/CMU, MIT "Your Brain on ChatGPT", Bastani et al. PNAS

### Takeaway
Three different methods point the same way. The MSR/CMU survey finds that higher confidence in AI goes with less critical thinking. The MIT EEG preprint finds lower neural engagement and poorer recall after LLM-assisted writing, but its methods have been contested. The Bastani et al. field RCT is the strongest causal evidence: with an unrestricted GPT-4, students did better during practice and **17% worse** on the exam once the AI was taken away. A guardrailed tutor removed the harm, though it did not produce a net gain.

### Cited Findings
- **MSR + CMU (Lee, Sarkar et al., CHI 2025):** a survey of **319 knowledge workers** with **936 first-hand examples** of GenAI use. — [Paper PDF](https://advait.org/files/lee_2025_ai_critical_thinking_survey.pdf); [Microsoft Research](https://www.microsoft.com/en-us/research/?p=1135061)
  - Higher confidence in GenAI was associated with less critical thinking. Higher self-confidence was associated with more.
  - GenAI shifts critical thinking toward verifying information, integrating responses and stewarding tasks.
  - Workers reported less critical effort on routine, low-stakes tasks under time pressure.
  - The data is self-reported and correlational. DOI 10.1145/3706598.3713778.

  — [Paper PDF](https://advait.org/files/lee_2025_ai_critical_thinking_survey.pdf)
- **MIT Media Lab, "Your Brain on ChatGPT" (Kosmyna et al., June 2025 preprint):**
  - Design: 54 participants from Boston-area universities were split into LLM (GPT-4o), search-engine and brain-only groups. 18 completed a fourth crossover session.
  - EEG connectivity "systematically scaled down with the amount of external support."
  - The LLM group reported the lowest ownership of their essays and struggled to quote essays they had just written.
  - In session 4, participants who switched from LLM to brain-only showed reduced alpha and beta connectivity.

  — [MIT Media Lab](https://www.media.mit.edu/publications/your-brain-on-chatgpt/); [brainonllm.com](https://www.brainonllm.com/)
- **Critique of the MIT study (arXiv 2601.00856, Jan 2026):** the comment argues the following. — [arXiv 2601.00856](https://arxiv.org/pdf/2601.00856)
  - Counting significant connections shows *greater* beta-band engagement for the LLM group.
  - Session 4 interview results are described in opposite directions in different sections.
  - The paper says 55 participants completed the experiments, but 54 were analyzed.
  - Reproducibility and transparency are limited.

  The study is an essay-writing task, not coding, and was a preprint at the time.
- **Bastani et al., PNAS 2025** (vol. 122(26), e2422633122): a field experiment with nearly 1,000 Turkish high-school math students. — [IDEAS/RePEc](https://ideas.repec.org/a/nas/journl/v122y2025pe2422633122.html); [SSRN](https://papers.ssrn.com/abstract=4895486); [Wharton Knowledge](https://knowledge.wharton.upenn.edu/article/without-guardrails-generative-ai-can-harm-education/)
  - During practice, grades rose **48%** with GPT Base (plain GPT-4) and **127%** with GPT Tutor (teacher-designed prompts with hints and no full answers).
  - On the unassisted exam, the GPT Base group scored **17% lower than control**. The GPT Tutor group scored about the same as control, so the harm was "largely mitigated" but there was no lasting gain.
  - The authors' mechanism is that students used GPT Base as a "crutch."

### Inferences
- Performance with AI during practice is a poor proxy for learning. This "performance–learning dissociation" also appears in the TUM and Anthropic RCTs (see section 4).
- Guardrails such as hints-not-answers prevent harm but have not yet shown clear gains on unassisted tests.
- Treat the MIT EEG results as suggestive only. Cite MSR/CMU as correlational.

### Gaps
- No long-term (months or more) causal study of cognitive offloading among professional developers was found.

---

## 4. CS education evidence: CS50 Duck, Prather, Kazemitabaar, Lehmann, Nie, TUM and other classroom studies

### Takeaway
Across CS education the pattern is consistent. Unrestricted LLM access raises task completion and scores *while the tool is present*, lowers stress, and often widens the gap between strong and weak students. Learning gains appear only when the AI is used as a complement (explanations, hints, scaffolding) rather than a substitute (generating solutions). Guardrailed tutors such as CS50 Duck and CodeAid are well liked and see heavy use, but rigorous learning-outcome evidence for them remains thin.

### Cited Findings
- **Harvard CS50 Duck (CS50.ai):** — [Liu et al., SIGCSE 2024 PDF](https://cs.harvard.edu/malan/publications/fp0627-liu.pdf)
  - Deployed first to about 70 summer students, then thousands online, then about 500 on-campus students in 2023.
  - It is designed as a guardrailed tutor that does not hand out solutions.
  - In the authors' own survey, about 75% of students used it frequently and 94% found it helpful. This is not a controlled outcome measure.
  - By mid-November 2024, about 211,000 students had used it, at roughly $1.50 per student per year. — [Liu et al. later version](https://cs.harvard.edu/malan/publications/V1fp0567-liu.pdf)
  - The SIGCSE 2025 follow-up ("Improving AI in CS50") found that the duck sometimes gave complete solutions ("instruction dilution"). Fixes using few-shot prompting, fine-tuning and human feedback were preferred by teaching fellows, a preliminary preference-based result. — [SIGCSE 2025 listing via search](https://sigcse2025.sigcse.org/details/sigcse-ts-2025-demos/8/Demo-4A-Assessment-in-CS50-with-AI-Leveraging-Generative-Artificial-Intelligence-fo)
- **Prather et al., "The Widening Gap" (ICER 2024):** 21 lab sessions with novices combining observation, interviews and eye tracking. — [arXiv 2405.17739](https://arxiv.org/abs/2405.17739v1); [Aalto summary](https://www.aalto.fi/en/news/aalto-computer-scientists-in-icer-2024)
  - 20 of 21 completed the task, but students split sharply. Those who accelerated used GenAI for code they had already planned and ignored bad suggestions.
  - Students who struggled had their metacognitive difficulties *compounded* by GenAI, including an illusion of competence.
  - Commentary reads this as GenAI being potentially "an impediment to their education" for some students. — [Teaching CS substack](https://teachingcs.substack.com/p/the-widening-gap)
- **Lehmann, Cornelius & Sting, "AI Meets the Classroom: When Do LLMs Harm Learning?"** — [arXiv 2409.09047](https://arxiv.org/abs/2409.09047v2)
  - Two pre-registered, incentivized lab experiments teaching Python, with a 45-minute learning phase and pre/post tests.
  - There was **no overall effect** on learning.
  - *Substitution* (having the LLM generate exercise solutions) increased the number of topics covered but decreased understanding of each.
  - *Complementing* (asking for explanations) increased understanding without increasing volume.
  - LLMs **widened the gap** between students with low and high prior knowledge.
- **Kazemitabaar et al., CodeAid (CHI 2024):** — [arXiv 2401.11314](https://arxiv.org/abs/2401.11314)
  - Deployed for 12 weeks in a 700-student C/systems course: 8,000+ uses, weekly surveys, 22 student and 8 educator interviews.
  - It answers conceptual questions and annotates buggy code with fix suggestions, without giving full solutions.
  - Students mainly used it for conceptual understanding and debugging. Only a minority sought direct code.
- **Kazemitabaar et al. (CHI 2023), Codex for novices:** 69 learners aged 10–17 used a self-paced Python environment. — [arXiv 2302.07427](https://arxiv.org/pdf/2302.07427)
  - The abstract reports 1.15× higher completion and 1.8× higher scores on code-authoring.
  - Manual code-modification performance did not drop.
  - On a post-test one week later, the Codex group was slightly but not significantly better.
  - **[Figures from my reading of the abstract; re-check before quoting.]**
- **Nie et al., "The GPT Surprise" (Stanford):** an RCT with **5,831 students in 146 countries** in an online coding course, 60% offered GPT-4 chat. — [arXiv 2407.09975](https://arxiv.org/abs/2407.09975v2)
  - Adopters scored higher on the exam.
  - Overall, *offering* GPT-4 significantly **reduced exam participation** and other engagement.
  - Access increased participation for students from low-HDI countries.
  - Long-run effects are unclear.
- **Bassner, Lenk-Ostendorf, Beinstingel, Wasner, Krusche (TUM), "Less stress, better scores, same learning", *Computers & Education: AI* vol. 10, 100537:** a three-arm RCT in CS1 with **N=275** on a concurrency exercise. — [TUM EdTech summary](https://www.edtech.tum.de/?p=3520); [ScienceDirect](https://www.sciencedirect.com/science/article/pii/S2666920X25001778)
  - Arms: a scaffolded hint tutor (Iris), unrestricted ChatGPT, and no AI.
  - Both AI arms **raised exercise scores and lowered frustration and cognitive load**, but **neither improved knowledge gain or code comprehension**.
  - Only the scaffolded tutor raised intrinsic motivation.
  - The authors call unrestricted solution-giving a "comfort trap" where progress outpaces understanding.
- **2026 cohort study in an intro programming course (Humanities & Social Sciences Communications, Nature portfolio):** students who received AI-generated feedback had significantly *lower* debugging performance and final exam scores than a cohort given data-driven feedback. The design is not randomized. — [Nature HSSC 2026](https://www.nature.com/articles/s41599-026-07920-7) *(snippet-level only)*
- **IZA DP 18792 (July 2026):** a general (non-programming) randomized experiment reporting that AI access raises *immediate* test scores by 0.27 SD. — [IZA DP 18792](https://docs.iza.org/dp18792.pdf) *(snippet-level only; full text not readable)*
- **AI capability vs. course assessments (Aug 2026):** five GenAI systems all scored above the average student on real intro OOP exams and often got full marks. They still occasionally produced non-compiling code and struggled with advanced OOP. — [arXiv 2608.16318](https://arxiv.org/abs/2608.16318v1)

### Inferences
- Every randomized study here that separates performance with AI from learning without it finds a dissociation: AI improves the first and not the second (TUM, Bastani, Anthropic, Lehmann). This is the most replicated finding in the area.
- The "widening gap" appears in both Prather and Lehmann: students with stronger prior knowledge or metacognition benefit, and weaker students are harmed. Beginners carry the most risk.
- Since AI now beats the average student on CS1 exams (arXiv 2608.16318), take-home assignments no longer certify skill. Learners need their own unassisted checks.

### Gaps
- No long-term controlled outcome evaluation of CS50 Duck was found.
- Specific exam-score effect sizes for the TUM RCT and the 2026 Nature cohort study could not be retrieved (paywall or 403).
- Denny et al. ("Prompt Problems", "Computing Education in the Era of Generative AI") and Prather et al.'s 2023 TOCHI Copilot study ("It's weird that it knows what I want") were not retrieved in this session.

---

## 5. Professional productivity and quality: Copilot RCTs, Google, DORA, Stack Overflow, GitClear

### Takeaway
Controlled studies on bounded tasks show large speedups: 55.8% on a greenfield toy task, about 21% at Google, and +26% completed tasks in field experiments, with the largest gains for less experienced developers. System-level data is more mixed. DORA 2024 linked AI adoption to *lower* delivery throughput and stability. DORA 2025 links it to higher throughput but continued instability. GitClear reports more duplication and less refactoring, and developer trust in AI accuracy is falling.

### Cited Findings
- **Peng, Kalliamvakou, Cihon, Demirer (2023):** in a controlled experiment building an HTTP server in JavaScript, the Copilot group was **55.8% faster** (95% CI 21–89%). Controls could use web search and Stack Overflow. — [arXiv 2302.06590](https://arxiv.org/pdf/2302.06590); [ar5iv](https://ar5iv.labs.arxiv.org/html/2302.06590?). The sample of about 95 recruited developers is **[unverified]**.
- **Cui, Demirer, Jaffe, Musolff, Peng, Salz, *Management Science* (2025):**
  - Three randomized field experiments of GitHub Copilot at Microsoft, Accenture and an anonymous Fortune 100 company, with **4,867 developers**.
  - Pooled estimate: **+26.08% completed tasks** (SE 10.3%). Each individual experiment is noisy.
  - Less experienced developers adopted more and gained more.
  - The Microsoft trial ran 7 months and the Accenture trial 4 months.

  — [SSRN 4945566](https://papers.ssrn.com/abstract=4945566); [Management Science DOI](https://pubsonline.informs.org/doi/fpi/10.1287/mnsc.2025.00535); [MIT Sloan](https://mitsloan.mit.edu/ideas-made-to-matter/how-generative-ai-affects-highly-skilled-workers)
- **Google enterprise RCT (Paradis et al., ICSE-SEIP 2025):** 96 full-time Google engineers on a complex enterprise task with code completion, Smart Paste and natural-language-to-code. The best estimate is about **21% less time**, with a wide CI. Developers who spent more hours coding per day benefited more. The authors caution against generalizing beyond summer-2024 internal tools. — [arXiv 2410.12944](https://arxiv.org/pdf/2410.12944)
- **DORA 2024:** each 25% increase in AI adoption was associated with: — [DORA 2024 infographic](https://dora.dev/research/2024/2024-DORA-Report-Infographic.pdf); [The New Stack](https://thenewstack.io/dora-2024-ai-and-platform-engineering-fall-short/); [RedMonk](https://redmonk.com/rstephens/2024/11/26/dora2024/)
  - +7.5% documentation quality, +3.4% code quality and +3.1% code review speed.
  - **−1.5% delivery throughput and −7.2% delivery stability.**
  - These are survey-based correlations.
- **DORA 2025 ("State of AI-assisted Software Development"):** — [TechRepublic](https://www.techrepublic.com/article/news-dora-ai-report-2025/); [digit.fyi](https://www.digit.fyi/ai-adoption-hits-90-among-developers-google-report-finds/); [InfoQ](https://www.infoq.com/news/2025/09/dora-state-of-ai-in-dev-2025)
  - About 5,000 respondents, about **90% use AI** at work (up 14%), around 2 hours a day.
  - AI is now associated with *higher* throughput, but not better pre-release quality, and instability persists.
  - Framing: AI is an "amplifier/mirror" of existing team strengths and dysfunction.
  - A secondary analysis notes that only 2 of 7 team clusters gain speed without higher change-failure rates. — [Rob Bowley blog](https://blog.robbowley.net/2025/10/01/dora-2025-ai-assisted-dev-report-some-benefit-most-dont/) *(secondary)*
- **Stack Overflow Developer Survey 2025** (fielded 29 May–23 Jun 2025): — [Stack Overflow blog](https://stackoverflow.blog/2025/07/29/developers-remain-willing-but-reluctant-to-use-ai-the-2025-developer-survey-results-are-here); [InfoWorld](https://infoworld.com/article/4031673/ai-use-among-software-developers-grows-but-trust-remains-an-issue-stack-overflow-survey.html)
  - **46% distrust** the accuracy of AI output, vs 31% the previous year. **33% trust** it and only **3% "highly trust"** it. The blog also cites 29% trust, so sources conflict.
  - The top frustration is AI solutions that are "almost right, but not quite", cited by **45%**.
  - **66%** say they spend more time fixing almost-right code.
  - **75%** would still ask a person when they don't trust AI's answer.
- **GitClear 2025** (211M changed lines, 2020–2024): — [DevClass](https://devclass.com/2025/02/20/ai-is-eroding-code-quality-states-new-in-depth-report/); [LeadDev](https://leaddev.com/software-quality/how-ai-generated-code-accelerates-technical-debt); [SoftwareSeni](https://www.softwareseni.com/the-evidence-against-vibe-coding-what-research-reveals-about-ai-code-quality/)
  - About an 8× rise in duplicated blocks of 5+ lines in 2024.
  - Copy-pasted lines exceeded "moved" (refactored) lines for the first time; moved lines fell 39.9%.
  - The refactoring share fell from about 25% of changed lines in 2021 to under 10% in 2024.
  - Caveats: GitClear sells code-analysis tools, the figures come from secondary coverage, and the data is observational and does not identify AI-written code directly.

### Inferences
- Speed gains are real on bounded, well-specified tasks, and largest for juniors. Juniors are also the group the learning studies show is most at risk of skill loss. Faster junior output and slower junior skill growth can happen together.
- At the system level, gains in code-writing speed do not automatically translate into delivery outcomes. Review, testing and design skills, which are the "senior" skills, become the bottleneck.

### Gaps
- No rigorous independent study of agentic tools (Claude Code, Cursor agent, Copilot agent) on long-run code quality was found beyond METR's noisy 2026 data.
- DORA 2025 primary report numbers were taken from trade-press summaries.

---

## 6. Vibe coding, deskilling, and juniors relying on AI

### Takeaway
Direct causal evidence on long-run deskilling of working developers does not yet exist. The best proxies are the short-term skill-formation RCTs (Anthropic, Bastani, TUM, Lehmann). All show that delegating to AI preserves output but not understanding, especially debugging. Labor data shows entry-level hiring in AI-exposed jobs falling, which raises the bar juniors must clear.

### Cited Findings
- In the Anthropic RCT, the worst-scoring patterns were full delegation (39%), progressive reliance (35%) and AI-as-debugger (24%). Debugging was the most impaired skill. — [Anthropic Research](https://www.anthropic.com/research/AI-assistance-coding-skills)
- The authors expect agentic tools like Claude Code to have *more* pronounced effects than the chat sidebar they tested. — [Anthropic Research](https://www.anthropic.com/research/AI-assistance-coding-skills)
- **"Canaries in the Coal Mine" (Brynjolfsson, Chandar, Chen; ADP payroll data):**
  - The Nov 2025 version reports a **16% relative employment decline** for workers aged 22–25 in AI-exposed occupations, software development among them. Employment of experienced workers was stable. — [Nov 2025 PDF](https://digitaleconomy.stanford.edu/app/uploads/2025/11/CanariesintheCoalMine_Nov25.pdf)
  - The Aug 2026 version puts young workers' employment **19% below** the counterfactual path, working mainly through reduced hiring rather than separations, with no economy-wide displacement. It calls these "descriptive, not causal" and notes the patterns attenuate when controlling for education, with some pre-trends. — [Aug 2026 PDF](https://digitaleconomy.stanford.edu/app/uploads/2026/08/Canaries_August2026.pdf)
  - Earlier drafts' 13% figure still circulates. — [Stanford DEL Feb 2026 note](https://digitaleconomy.stanford.edu/news/canaries-interest-rates-and-timinga-more-on-recent-drivers-of-employment-changes-for-young-workers)
- The "comfort trap" (TUM): unrestricted AI raised scores and lowered cognitive load without improving comprehension. — [TUM EdTech](https://www.edtech.tum.de/?p=3520)
- The MSR/CMU survey links higher trust in AI to less critical thinking, and lower effort on routine tasks under time pressure. — [Lee et al. 2025](https://advait.org/files/lee_2025_ai_critical_thinking_survey.pdf)
- GitClear reports more copy-paste and less refactoring in the AI era. — [DevClass](https://devclass.com/2025/02/20/ai-is-eroding-code-quality-states-new-in-depth-report/)
- In 2026, many METR developers refused to do tasks without AI. — [METR uplift update](https://metr.org/blog/2026-02-24-uplift-update/)

### Inferences
- "Vibe coding" (accepting AI code without understanding it) is precisely the "AI delegation" or "substitution" pattern that the RCTs show produces the lowest comprehension and debugging ability.
- With fewer entry-level openings, juniors are judged more on the skills AI does not supply: debugging, reading unfamiliar code, judgment and review. Those are the same skills that over-reliance erodes.

### Gaps
- No peer-reviewed longitudinal study (6+ months) measuring professional developers' unassisted skill decline was found.
- No rigorous security or quality study specific to "vibe-coded" applications was retrieved in this session.

---

## Evidence-backed rules: "use AI to learn, not to replace learning"

Each rule cites its evidence. These rules are the report-writer's synthesis guidance; they apply findings from the sources above.

1. **Ask conceptual questions and do not delegate when learning something new.** Conceptual inquiry kept quiz scores near control (65% vs 67%), while delegation dropped them to 24–39%. — [Anthropic](https://www.anthropic.com/research/AI-assistance-coding-skills); complementing improves understanding while substituting reduces it — [Lehmann et al.](https://arxiv.org/abs/2409.09047v2)
2. **If you generate code, interrogate it before moving on.** Ask why it works and what the alternatives are, and be able to explain each line. The generation-then-comprehension pattern scored 86%. — [Anthropic](https://www.anthropic.com/research/AI-assistance-coding-skills)
3. **Debug yourself first.** AI-as-debugger was the worst pattern (24%), and debugging was the largest skill gap. — [Anthropic](https://www.anthropic.com/research/AI-assistance-coding-skills); AI feedback cohorts did worse on debugging and exams — [Nature HSSC 2026](https://www.nature.com/articles/s41599-026-07920-7)
4. **Prefer hint-only or Socratic tools and modes while learning.** Examples are a tutor-style system prompt, Claude Learning mode, and Claude Code's Learning style with `TODO(human)`. Guardrailed GPT Tutor removed the 17% exam harm. — [Bastani et al.](https://knowledge.wharton.upenn.edu/article/without-guardrails-generative-ai-can-harm-education/); scaffolded tutors raised motivation — [TUM](https://www.edtech.tum.de/?p=3520); [Claude Code output styles](https://code.claude.com/docs/en/output-styles). Caveat: these modes have not been proven to produce *gains*.
5. **Regularly test yourself without AI.** Performance with AI does not predict unassisted performance: +48% in practice became −17% on the exam. — [Bastani et al.](https://ideas.repec.org/a/nas/journl/v122y2025pe2422633122.html); higher scores with "same learning" — [TUM](https://www.edtech.tum.de/?p=3520)
6. **Accept being stuck for a while.** "Cognitive effort—and even getting painfully stuck—is likely important for fostering mastery." — [Anthropic](https://www.anthropic.com/research/AI-assistance-coding-skills)
7. **Measure outcomes, don't trust the feeling of speed.** Developers felt about 20% faster while measured 19% slower. — [METR](https://metr.org/blog/2025-07-10-early-2025-ai-experienced-os-dev-study/)
8. **Keep self-confidence and skepticism calibrated.** Trust in AI correlates with less critical thinking. — [Lee et al.](https://advait.org/files/lee_2025_ai_critical_thinking_survey.pdf); 66% spend extra time fixing "almost right" code — [Stack Overflow 2025](https://stackoverflow.blog/2025/07/29/developers-remain-willing-but-reluctant-to-use-ai-the-2025-developer-survey-results-are-here)
9. **Beginners need the most discipline.** AI widens the gap between low- and high-prior-knowledge students. — [Lehmann](https://arxiv.org/abs/2409.09047v2); [Prather "Widening Gap"](https://arxiv.org/abs/2405.17739v1)
10. **Use AI freely for speed on tasks you already understand.** Accelerating students used it for "code they already intended to write." — [Prather](https://www.aalto.fi/en/news/aalto-computer-scientists-in-icer-2024); speed gains are largest on bounded tasks — [Cui et al.](https://papers.ssrn.com/abstract=4945566); [Google RCT](https://arxiv.org/pdf/2410.12944)
11. **Invest in review, refactoring and system skills.** AI-era codebases show more duplication and less refactoring. — [GitClear via DevClass](https://devclass.com/2025/02/20/ai-is-eroding-code-quality-states-new-in-depth-report/); AI amplifies existing team practices and does not fix them — [DORA 2025](https://www.infoq.com/news/2025/09/dora-state-of-ai-in-dev-2025)
