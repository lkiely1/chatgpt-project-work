package com.example.springbootapp.graphql;

import com.example.springbootapp.model.Household;
import com.example.springbootapp.model.Pet;
import com.example.springbootapp.service.HouseholdService;
import com.example.springbootapp.service.PetService;
import com.example.springbootapp.dto.HouseholdInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MutationController {
    private final HouseholdService householdService;
    private final PetService petService;

    public Household createNewHousehold(HouseholdInput input) {
        Household household = new Household(input.getAddress(), input.getOccupants());
        return householdService.createHousehold(household);
    }

    public Boolean deleteHouseholdById(Long id) {
        householdService.deleteHousehold(id);
        return true;
    }

    public Boolean deletePetById(Long id) {
        petService.deletePetById(id);
        return true;
    }
}
