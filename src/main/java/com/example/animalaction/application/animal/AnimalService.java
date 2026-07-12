package com.example.animalaction.application.animal;

import com.example.animalaction.domain.animal.Animal;
import java.time.Instant;
import java.util.*;

public class AnimalService {
  private final AnimalRepository animalRepository;
  private final AnimalEventPublisher animalEventPublisher;

  public AnimalService(AnimalRepository animalRepository, AnimalEventPublisher animalEventPublisher) {
    this.animalRepository = animalRepository;
    this.animalEventPublisher = animalEventPublisher;
  }

  public Animal register(String name, String species) {
    var animal = animalRepository.save(Animal.register(name, species, Instant.now()));
    animalEventPublisher.publish("AnimalRegistered", animal, null);
    return animal;
  }

  public List<Animal> all() {
    return animalRepository.findAll();
  }

  public Animal get(UUID id) {
    return animalRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Animal not found: " + id));
  }

  public Animal execute(UUID id, String action) {
    var animal = get(id);
    if (action == null || action.isBlank()) {
      throw new IllegalArgumentException("Action is required");
    }
    animalEventPublisher.publish("AnimalActionExecuted", animal, action.trim());
    return animal;
  }
}
