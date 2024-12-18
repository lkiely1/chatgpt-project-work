package com.example.springbootapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PetDTO(
        Long id,
        @NotNull @Size(min = 1) String name,
        @NotNull String animalType,
        @NotNull String breed,
        @NotNull Integer age
) {}
