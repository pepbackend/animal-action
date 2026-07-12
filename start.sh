#!/usr/bin/env bash
set -euo pipefail
mvn clean package -DskipTests
docker compose up -d postgres kafka
java -jar target/animal-action-*.jar
