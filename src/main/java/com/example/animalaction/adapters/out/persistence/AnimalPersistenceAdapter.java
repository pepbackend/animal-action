package com.example.animalaction.adapters.out.persistence;

import com.example.animalaction.application.animal.AnimalRepository;
import com.example.animalaction.domain.animal.Animal;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class AnimalPersistenceAdapter implements AnimalRepository {
  private final SpringAnimalRepository springAnimalRepository;

  public AnimalPersistenceAdapter(SpringAnimalRepository springAnimalRepository) {
    this.springAnimalRepository = springAnimalRepository;
  }

  public Animal save(Animal animal) {
    var savedEntity = springAnimalRepository.save(
        new AnimalJpaEntity(animal.id(), animal.name(), animal.species(), animal.createdAt()));
    return map(savedEntity);
  }

  public Optional<Animal> findById(UUID id) {
    return springAnimalRepository.findById(id).map(this::map);
  }

  public List<Animal> findAll() {
    return springAnimalRepository.findAll().stream().map(this::map).toList();
  }

  private Animal map(AnimalJpaEntity entity) {
    return new Animal(entity.id(), entity.name(), entity.species(), entity.createdAt());
  }
}
