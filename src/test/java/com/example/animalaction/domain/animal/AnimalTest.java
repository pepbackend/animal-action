package com.example.animalaction.domain.animal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import org.junit.jupiter.api.Test;

class AnimalTest {
  @Test
  void trimsName() {
    assertEquals("Rex", Animal.register(" Rex ", "dog", Instant.EPOCH).name());
  }

  @Test
  void requiresSpecies() {
    assertThrows(IllegalArgumentException.class, () -> Animal.register("Rex", "", Instant.EPOCH));
  }
}
