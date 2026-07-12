package com.example.animalaction.adapters.out.persistence;

import com.example.animalaction.application.animal.AnimalRepository;
import com.example.animalaction.domain.animal.Animal;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class AnimalPersistenceAdapter implements AnimalRepository {
  private final SpringAnimalRepository r;

  public AnimalPersistenceAdapter(SpringAnimalRepository r) {
    this.r = r;
  }

  public Animal save(Animal a) {
    var e = r.save(new AnimalJpaEntity(a.id(), a.name(), a.species(), a.createdAt()));
    return map(e);
  }

  public Optional<Animal> findById(UUID id) {
    return r.findById(id).map(this::map);
  }

  public List<Animal> findAll() {
    return r.findAll().stream().map(this::map).toList();
  }

  private Animal map(AnimalJpaEntity e) {
    return new Animal(e.id(), e.name(), e.species(), e.createdAt());
  }
}
