# ADR-0001: Ports and Adapters

Status: accepted

We keep domain rules independent from Spring, JPA, Kafka, and HTTP. This allows fast unit tests, isolates infrastructure changes, and makes use cases reusable across adapters. The cost is explicit mapping and more packages.
