package com.example.animalaction.adapters.out.persistence;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "animals")
public class AnimalJpaEntity {
  @Id UUID id;
  String name;
  String species;
  Instant createdAt;

  protected AnimalJpaEntity() {}

  public AnimalJpaEntity(UUID id, String name, String species, Instant createdAt) {
    this.id = id;
    this.name = name;
    this.species = species;
    this.createdAt = createdAt;
  }

  public UUID id() {
    return id;
  }

  public String name() {
    return name;
  }

  public String species() {
    return species;
  }

  public Instant createdAt() {
    return createdAt;
  }
}
