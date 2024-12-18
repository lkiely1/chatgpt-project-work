package com.example.springbootapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;

@Data
@Entity
@RequiredArgsConstructor

@Getter
@Setter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    private String animalType;

    @NotBlank
    private String breed;

    @Min(0)
    private int age;

    @ManyToOne
    @JoinColumn(name = "eircode", nullable = false)
    private Household household;

    public Pet(String name, String animalType, String breed, int age, Household household) {
        this.name = name;
        this.animalType = animalType;
        this.breed = breed;
        this.age = age;
        this.household = household;

    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for animalType
    public String getAnimalType() {
        return animalType;
    }

    // Getter for breed
    public String getBreed() {
        return breed;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Getter for eircode
    public Household getHousehold() {
        return household;
    }

    // Setter for id (if you need setters as well)
    public void setId(Long id) {
        this.id = id;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for animalType
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    // Setter for breed
    public void setBreed(String breed) {
        this.breed = breed;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }


}
