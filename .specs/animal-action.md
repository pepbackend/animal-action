# Animal Action

Status: implemented

Register animals, retrieve them, and execute named actions. Successful registration and action execution publish versioned events to Kafka topic `animal-actions`; the service also exposes a typed listener for that topic.

Animals have a UUID, non-blank trimmed name and species, and UTC creation time. Actions are non-blank. Persistence precedes publication; delivery is at-least-once and consumers deduplicate by `eventId`.
