# Architecture

The service uses a ports-and-adapters architecture. The domain is the center; application use cases depend on ports; adapters implement those ports.

## Runtime topology

REST clients call the inbound HTTP adapter. Application use cases validate and coordinate domain behavior. The outbound persistence adapter stores Animals in PostgreSQL through JPA/Flyway. The outbound event adapter publishes versioned Animal events to Kafka topic `animal-actions`, which is also consumed by the inbound listener.

## Boundaries

The domain must compile without Spring. HTTP DTOs, JPA entities, and Kafka payloads do not cross into the domain. Mapping is explicit at adapter boundaries.

## Reliability baseline

The template assumes at-least-once event delivery. Consumers must be idempotent. Direct publication is acceptable for local development only; resolve the transactional outbox decision before production.
