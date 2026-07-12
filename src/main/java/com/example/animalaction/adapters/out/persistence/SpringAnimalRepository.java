package com.example.animalaction.adapters.out.persistence;
import org.springframework.data.jpa.repository.JpaRepository; import java.util.UUID;
public interface SpringAnimalRepository extends JpaRepository<AnimalJpaEntity,UUID>{}
