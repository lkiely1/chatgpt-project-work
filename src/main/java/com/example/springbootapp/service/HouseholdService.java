package com.example.springbootapp.service;

import com.example.springbootapp.dto.HouseholdDTO;
import com.example.springbootapp.exception.ResourceNotFoundException;
import com.example.springbootapp.model.Household;
import com.example.springbootapp.repository.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdService {
    private final HouseholdRepository householdRepository;

    @Autowired
    public HouseholdService(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }


    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }



    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    public Household getHouseholdByEircode(String eircode, boolean withPets) {
        if (withPets) {
            return householdRepository.findByEircodeWithPets(eircode);
        }
        return householdRepository.findById(eircode)
                .orElseThrow(() -> new ResourceNotFoundException("Household not found with eircode " + eircode));
    }

    public List<Household> findHouseholdsWithNoPets() {
        return householdRepository.findHouseholdsWithNoPets();
    }

    public List<Household> findOwnerOccupiedHouseholds() {
        return householdRepository.findByOwnerOccupiedTrue();
    }

    public void deleteHousehold(String eircode) {
        householdRepository.deleteById(eircode);
    }

    public ResponseEntity<HouseholdDTO> getHouseholdById(Long id) {
        return null;
    }
}
