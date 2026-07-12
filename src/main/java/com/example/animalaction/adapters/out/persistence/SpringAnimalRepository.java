package com.example.animalaction.adapters.out.persistence;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringAnimalRepository extends JpaRepository<AnimalJpaEntity, UUID> {}
