# Domain Language

| Term | Meaning | Invariant |
| --- | --- | --- |
| Animal | A registered animal managed by this service | Has a UUID, non-blank name and species |
| Action | A named behavior requested for an animal | Is non-blank |
| AnimalRegistered | Event emitted after successful registration | Contains the animal snapshot |
| AnimalActionExecuted | Event emitted after an action request | Contains the animal identity and action |

Use UTC `Instant` values and UUID identifiers. Kafka delivery is at-least-once; consumers deduplicate by `eventId`.
