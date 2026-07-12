#!/usr/bin/env bash
set -euo pipefail
docker compose down

# Stop any local process that is still occupying the application's HTTP port.
listener_pids="$(lsof -tiTCP:8080 -sTCP:LISTEN 2>/dev/null || true)"
if [[ -n "$listener_pids" ]]; then
  kill $listener_pids 2>/dev/null || true
  sleep 1
  remaining_pids="$(lsof -tiTCP:8080 -sTCP:LISTEN 2>/dev/null || true)"
  [[ -z "$remaining_pids" ]] || kill -KILL $remaining_pids 2>/dev/null || true
fi
