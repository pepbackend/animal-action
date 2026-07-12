# Product CRUD

Read `AGENTS.md` and `docs/README.md` before implementing this spec. Update the relevant docs and add an entry to `docs/iterations/README.md` when behavior changes.

The HTTP contract is defined first in `src/main/resources/openapi/openapi.yaml`. Any endpoint change must update that document before implementation.

## Status

Template specification. The current code contains the domain seed and tests; HTTP, persistence mapping, and Kafka adapters are intentionally future implementation slices.

## Scope

Create, retrieve, update, and delete a Product aggregate through application ports and REST adapters.

## Domain language

Product identity, name, description, price, creation time, and update time are defined in `docs/domain-language.md`.

## Acceptance criteria

- Given a valid name and positive price, when a product is created, then it is persisted and a `ProductCreated` event is published.
- Given an existing id, when it is requested, then its current representation is returned.
- Given an unknown id, then the API returns `404`.
- Given invalid input, then the API returns `400` and no event is published.
- On update or delete, the corresponding event is published after successful persistence.

Use UUID identifiers, UTC timestamps, Flyway migrations, JSON events, and no domain dependency on infrastructure frameworks.

## Event contract

Events use the `product-events` topic, the product UUID as the Kafka key, and a versioned JSON envelope containing `eventType`, `eventVersion`, `eventId`, `occurredAt`, and `payload`. Delivery is at-least-once; consumers must be idempotent. The outbox decision remains open and must be resolved before production use.

## Non-functional requirements

Return RFC 9457-style errors, do not log secrets or full credentials, expose health/readiness checks, and preserve backward compatibility for versioned event payloads.

## Test matrix

Cover valid and invalid domain creation, use-case not-found behavior, repository mapping, HTTP validation/status codes, Kafka serialization, and a PostgreSQL/Kafka integration path.

## Open questions

- Choose transactional outbox versus direct Kafka publication.
- Define update concurrency and idempotency keys.
- Define authentication, authorization, and retention policy.
