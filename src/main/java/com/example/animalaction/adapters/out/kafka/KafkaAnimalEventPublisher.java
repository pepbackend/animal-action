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
      KafkaTemplate<String, Object> kafkaTemplate,
      @Value("${spring.kafka-topics.actions:animal-actions}") String topicName) {
    kafka = kafkaTemplate;
    topic = topicName;
  }

  public void publish(String type, Animal animal, String action) {
    kafka.send(
        topic,
        animal.id().toString(),
        new Event(
            UUID.randomUUID(),
            type,
            animal.id(),
            animal.name(),
            animal.species(),
            action,
            Instant.now()));
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
