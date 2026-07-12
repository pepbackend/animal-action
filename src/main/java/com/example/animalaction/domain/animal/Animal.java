package com.example.animalaction.domain.animal;

import java.time.Instant;
import java.util.UUID;

public record Animal(UUID id, String name, String species, Instant createdAt) {
  public static Animal register(String name, String species, Instant now) {
    if (name == null || name.isBlank() || species == null || species.isBlank()) {
      throw new IllegalArgumentException("Animal name and species are required");
    }
    return new Animal(UUID.randomUUID(), name.trim(), species.trim(), now);
  }
}
