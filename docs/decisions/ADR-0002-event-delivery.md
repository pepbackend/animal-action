# ADR-0002: Event Delivery

Status: open

The local template publishes directly to Kafka after persistence. Before production, compare a transactional outbox with direct publication and document the selected atomicity, retry, ordering, deduplication, and replay behavior.
