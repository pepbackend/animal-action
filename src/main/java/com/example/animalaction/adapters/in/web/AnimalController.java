package com.example.animalaction.adapters.in.web;

import com.example.animalaction.application.animal.AnimalService;
import com.example.animalaction.domain.animal.Animal;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {
  private final AnimalService animalService;

  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @PostMapping
  public ResponseEntity<Animal> register(@Valid @RequestBody Request request) {
    return ResponseEntity.status(201).body(animalService.register(request.name(), request.species()));
  }

  @GetMapping
  public List<Animal> all() {
    return animalService.all();
  }

  @GetMapping("/{id}")
  public Animal get(@PathVariable UUID id) {
    return animalService.get(id);
  }

  @PostMapping("/{id}/actions")
  public Animal action(@PathVariable UUID id, @Valid @RequestBody Action actionRequest) {
    return animalService.execute(id, actionRequest.action());
  }

  public record Request(@NotBlank String name, @NotBlank String species) {}

  public record Action(@NotBlank String action) {}
}
