package com.example.springbootapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Household {
    @Id
    @Column(length = 10)
    @NotBlank
    @Size(max = 10)
    private String eircode;

    @Min(0)
    private int numberOfOccupants;

    @Min(1)
    private int maxOccupants;

    private boolean ownerOccupied;

    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets;

    public int getNumberOfPets() {
        return pets == null ? 0 : pets.size();
    }
}
