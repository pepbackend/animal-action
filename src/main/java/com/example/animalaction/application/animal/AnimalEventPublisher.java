package com.example.animalaction.application.animal;

import com.example.animalaction.domain.animal.Animal;

public interface AnimalEventPublisher {
  void publish(String type, Animal animal, String action);
}
