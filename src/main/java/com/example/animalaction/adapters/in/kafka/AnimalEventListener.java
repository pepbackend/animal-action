package com.example.animalaction.adapters.in.kafka;
import org.springframework.kafka.annotation.KafkaListener; import org.springframework.stereotype.Component; import com.example.animalaction.adapters.out.kafka.KafkaAnimalEventPublisher.Event;
@Component public class AnimalEventListener { @KafkaListener(topics="${spring.kafka-topics.actions:animal-actions}") public void listen(Event event){ /* integration hook; consumers are idempotent by eventId */ } }
