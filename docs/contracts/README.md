# Contracts

The canonical HTTP contract is `src/main/resources/openapi/openapi.yaml`; this folder stores reviewed examples, event schemas, and compatibility notes. Every externally consumed event must document topic, key, envelope, payload, schema version, compatibility policy, producer, consumers, and retention. Breaking changes require a new version and an ADR.

The OpenAPI contract must be reviewed before implementation, validated in CI, and exercised with contract tests. Every feature begins with this contract (or its event equivalent), followed by failing tests under a TDD workflow. Swagger UI is exposed locally for human review at `/swagger-ui.html`.
