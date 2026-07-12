# Feature Development Skill

## Inputs

Read `AGENTS.md`, `docs/README.md`, the target spec, related decision records, and the recent iteration notes. Identify the bounded context, aggregate, commands, queries, domain events, external contracts, and operational risks.

## Spec-first loop

Update `.specs/<feature>.md` before coding. Include: problem statement, scope/out of scope, glossary links, assumptions, invariants, sequence or state transitions, HTTP and event contracts, Given/When/Then criteria, failure behavior, observability, security, migration/rollback notes, and open questions.

## API-first loop

For an HTTP feature, edit `src/main/resources/openapi/openapi.yaml` before controller code. Validate the document, review examples and compatibility, and derive controller DTOs and tests from the contract. Keep domain models separate from OpenAPI transport schemas.

## TDD loop

Write the smallest failing domain test. Make it pass. Refactor. Repeat for the application use case, then add adapter contract tests and infrastructure integration tests. Tests should assert behavior and published event semantics, not implementation details.

## Implementation checklist

- Keep domain objects framework-free.
- Define ports in the application layer.
- Map DTOs, persistence records, and event payloads explicitly.
- Make event consumers idempotent and document the chosen key, topic, schema version, and ordering assumptions.
- Add a Flyway migration for persistent changes.
- Avoid broad refactors during a feature.

## Exit criteria

Acceptance criteria pass, the OpenAPI contract is reviewed and tested, Swagger UI renders, `mvn verify` passes, integration dependencies are reproducible, API/event examples are documented, and the iteration note records changed files, decisions, tests, and follow-up work.
