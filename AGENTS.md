# Agent Contract

This repository is a spec-driven template for a Spring Boot microservice using ports and adapters, DDD, and TDD. The source of truth is distributed across the applicable spec, the decision records in `docs/decisions/`, and the code.

## API-first contract and TDD

The versioned OpenAPI document in `src/main/resources/openapi/openapi.yaml` is the source of truth for HTTP APIs. Design and review the contract before implementing controllers or application ports. Every endpoint must define operation id, parameters, request/response schemas, status codes, validation constraints, error format, examples, and security requirements. Swagger UI is a review surface, not the source of truth.

When an API changes, update the OpenAPI document first, add contract tests, then implement the adapter. Breaking changes require a new API version or an approved ADR. Generated clients/models must be reproducible and must not be hand-edited.

Every new feature starts from its externally observable API or event contract and follows TDD. First write or update the applicable specification and OpenAPI/event contract, then add a failing test for each acceptance criterion, implement the minimum domain/application behavior to make the tests pass, add adapters, and finish with verification. Do not implement feature behavior before its contract and failing test exist.

## Required context loading

Before changing code, read this file, `docs/README.md`, the applicable `.specs/<feature>.md`, and any linked documents. Search `docs/iterations/` for recent context. If the requirement is unclear, record the assumption in the spec instead of silently inventing behavior.

## Delivery workflow

1. Create or update a spec with scope, glossary, invariants, API/event contracts, acceptance criteria, non-functional requirements, and open questions.
2. Update and review the API/event contract before writing implementation code.
3. Add failing unit, acceptance, or API contract tests for each behavior before implementing it.
4. Implement domain behavior without Spring, JPA, Kafka, or HTTP imports.
5. Implement application use cases behind inbound and outbound ports.
6. Add adapters and contract/integration tests. Use Testcontainers for PostgreSQL and Kafka tests.
7. Run `mvn verify`, inspect the diff, update docs and the iteration log, and report limitations.

## Architecture boundaries

- `domain`: aggregates, value objects, domain services, and domain events. Framework-free.
- `application`: use cases, inbound ports, outbound ports, and transaction orchestration.
- `adapters/in`: REST controllers, messaging consumers, DTOs, and boundary validation.
- `adapters/out`: JPA repositories, Kafka publishers, and external clients.
- Dependencies point inward. Controllers never expose JPA entities.

## Design rules

- Keep domain language consistent with the glossary in `docs/domain-language.md`.
- Prefer explicit mapping at every adapter boundary.
- Publish events only after successful state changes; document delivery and idempotency semantics.
- Add a Flyway migration for schema changes. Never use `ddl-auto` to mutate a shared database.
- Do not add retries, caching, async processing, or distributed transactions without a documented decision record.
- Never commit credentials, personal data, generated output, or unreviewed dependency upgrades.

## Verification and handoff

Run `mvn verify`; for infrastructure changes also run `docker compose config` and the relevant integration profile. Use deterministic tests and meaningful failure messages. Update the spec status, relevant `docs/` pages, and `docs/iterations/README.md` before handoff.

Use conventional commit prefixes: `feat:`, `fix:`, `test:`, `refactor:`, `docs:`, or `chore:`.
