package com.example.springbootapp.graphql;

import com.example.springbootapp.model.Household;
import com.example.springbootapp.model.Pet;
import com.example.springbootapp.service.HouseholdService;
import com.example.springbootapp.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QueryController {
    private final HouseholdService householdService;
    private final PetService petService;

    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    public List<Pet> getAllPetsByAnimalType(String animalType) {
        return petService.findPetsByAnimalType(animalType);
    }

    public Household getHousehold(Long id) {
        return householdService.getHouseholdById(id);
    }

    public Pet getPet(Long id) {
        return petService.getPetById(id);
    }

    public PetStatistics getPetStatistics() {
        double averageAge = petService.getAverageAge();
        int oldestPetAge = petService.getOldestPetAge();
        return new PetStatistics(averageAge, oldestPetAge);
    }
}
