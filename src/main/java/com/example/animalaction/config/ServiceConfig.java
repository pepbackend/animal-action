package com.example.animalaction.config;

import com.example.animalaction.application.animal.*;
import org.springframework.context.annotation.*;

@Configuration
public class ServiceConfig {
  @Bean
  AnimalService animalService(AnimalRepository r, AnimalEventPublisher p) {
    return new AnimalService(r, p);
  }
}
