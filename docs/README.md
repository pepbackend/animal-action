# Project Knowledge Base

This folder preserves durable context for humans and AI agents. It is part of the product, not a scratchpad.

## Reading order

1. `../AGENTS.md`
2. The relevant `.specs/` document
3. `architecture.md` and `domain-language.md`
4. Relevant files in `decisions/`, `contracts/`, and `iterations/`

## Contents

- `architecture.md`: boundaries, dependency direction, and runtime topology.
- `domain-language.md`: canonical terms and invariants.
- `decisions/`: one short ADR per significant technical or domain decision.
- `contracts/`: HTTP and event examples, schemas, compatibility notes, and ownership.
- `iterations/`: dated development notes recording context gained and remaining work.
- `runbooks/`: local operation, troubleshooting, and recovery procedures.

## Maintenance rules

Update docs in the same change as behavior. Prefer small factual pages over long transcripts. Link decisions from specs. Mark uncertainty as `OPEN` and include an owner or next action. Never place secrets, production data, access tokens, or private customer information here.
