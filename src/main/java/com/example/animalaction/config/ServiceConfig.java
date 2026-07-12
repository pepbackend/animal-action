package com.example.animalaction.config;

import com.example.animalaction.application.animal.AnimalEventPublisher;
import com.example.animalaction.application.animal.AnimalRepository;
import com.example.animalaction.application.animal.AnimalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
  @Bean
  AnimalService animalService(AnimalRepository animalRepository, AnimalEventPublisher animalEventPublisher) {
    return new AnimalService(animalRepository, animalEventPublisher);
  }
}
