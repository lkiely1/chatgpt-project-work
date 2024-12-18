package com.example.springbootapp.service;

import com.example.springbootapp.dto.PetDTO;
import com.example.springbootapp.exception.ResourceNotFoundException;
import com.example.springbootapp.model.Pet;
import com.example.springbootapp.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with ID " + id));
    }

    public Pet updatePet(Long id, Pet updatedPet) {
        Pet pet = getPetById(id);
        pet.setName(updatedPet.getName());
        pet.setAge(updatedPet.getAge());
        return petRepository.save(pet);
    }

    public void deletePetById(Long id) {
        Pet pet = getPetById(id);
        petRepository.delete(pet);
    }

    public void deletePetsByName(String name) {
        List<Pet> pets = petRepository.findByNameIgnoreCase(name);
        petRepository.deleteAll(pets);
    }

    public List<Pet> findPetsByAnimalType(String type) {
        return petRepository.findByAnimalTypeIgnoreCase(type);
    }

    public List<Pet> findPetsByBreed(String breed) {
        return petRepository.findByBreedOrderByAgeAsc(breed);
    }

    public List<Pet> findNameAndBreed() { // ai forgot it used "find" in petRepository here but remembered next line
        return petRepository.findNameAndBreed();
    }

    public double getAverageAge() {
        return petRepository.findAll().stream().mapToInt(Pet::getAge).average().orElse(0.0);
    }

    public int getOldestPetAge() {
        return petRepository.findAll().stream().mapToInt(Pet::getAge).max().orElse(0);
    }

    //public ResponseEntity<Pet> updatePetName(Long id, String name) {
    //    return petRepository.updatePetName();
    //}

    public void deletePet(Long id) {
    }
}
