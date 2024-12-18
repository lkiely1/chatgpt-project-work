package com.example.springbootapp.repository;

import com.example.springbootapp.dto.PetDTO;
import com.example.springbootapp.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; // ai ommited
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByAnimalTypeIgnoreCase(String animalType);

    List<Pet> findByBreedOrderByAgeAsc(String breed);

    List<Pet> findByNameIgnoreCase(String name);

    @Query("SELECT  p.name as name, p.animalType as animalType, p.breed as breed, p.age as age FROM Pet p")
    List<Pet> findNameAndBreed();


    //ResponseEntity<Pet> updatePetName();
}
