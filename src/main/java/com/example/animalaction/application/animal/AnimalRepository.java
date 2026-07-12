package com.example.animalaction.application.animal;

import com.example.animalaction.domain.animal.Animal;
import java.util.*;

public interface AnimalRepository {
  Animal save(Animal a);

  Optional<Animal> findById(UUID id);

  List<Animal> findAll();
}
