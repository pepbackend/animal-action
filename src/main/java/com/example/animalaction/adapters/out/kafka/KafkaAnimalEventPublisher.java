package com.example.animalaction.adapters.out.kafka;

import com.example.animalaction.application.animal.AnimalEventPublisher;
import com.example.animalaction.domain.animal.Animal;
import java.time.Instant;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaAnimalEventPublisher implements AnimalEventPublisher {
  private final KafkaTemplate<String, Object> kafka;
  private final String topic;

  public KafkaAnimalEventPublisher(
      KafkaTemplate<String, Object> k,
      @Value("${spring.kafka-topics.actions:animal-actions}") String t) {
    kafka = k;
    topic = t;
  }

  public void publish(String type, Animal a, String action) {
    kafka.send(
        topic,
        a.id().toString(),
        new Event(UUID.randomUUID(), type, a.id(), a.name(), a.species(), action, Instant.now()));
  }

  public record Event(
      UUID eventId,
      String type,
      UUID animalId,
      String name,
      String species,
      String action,
      Instant occurredAt) {}
}
