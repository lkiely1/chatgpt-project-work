package com.example.springbootapp.dto;

import jakarta.validation.constraints.NotNull;

public record HouseholdDTO(
        Long id,
        @NotNull String eircode,
        @NotNull Integer numberOfOccupants,
        @NotNull Integer maxOccupants,
        Boolean isOwnerOccupied,
        Integer numberOfPets
) {}
