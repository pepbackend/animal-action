# Animal Action

Java 21, Spring Boot, Maven, ports and adapters, DDD, TDD, PostgreSQL, Flyway, and Kafka.

Run `./start.sh` to build and start the service plus local infrastructure. Run `./stop.sh` to stop containers. The API registers animals and executes actions with `POST /api/animals/{animalId}/actions`.

The API contract is defined first in `src/main/resources/openapi/openapi.yaml`. Swagger UI is available at `http://localhost:8080/swagger-ui.html`, and the generated document at `/v3/api-docs`.

Read [AGENTS.md](AGENTS.md) before changing code. Every new feature starts at the API or event contract, then follows TDD: spec and contract, failing tests, domain/application code, adapters, verification, and documentation.
