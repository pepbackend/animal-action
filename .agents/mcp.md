# MCP Template

Use a small, explicit allowlist. Every server runs with the minimum permissions needed for the current task, and its version/source is recorded in the iteration note.

## Recommended baseline

- GitHub's maintained MCP server for issues, pull requests, reviews, and repository context.
- Context7 for retrieving current, version-specific framework and library documentation.
- A PostgreSQL MCP server in read-only mode for local schema inspection and safe queries.

## Optional

- A vetted Kafka MCP server for local topic, consumer-group, and message inspection. The Kafka MCP ecosystem is less standardized than GitHub or PostgreSQL; use the Kafka CLI or observability tools when a server's maintenance, permissions, and provenance are unclear.

## Security policy

Do not connect an agent MCP to production databases, brokers, credentials, email, or customer data by default. Prefer read-only roles, localhost-only containers, pinned versions, reviewed source, network egress restrictions, and explicit approval for writes. Treat third-party MCP servers as executable supply-chain dependencies.
