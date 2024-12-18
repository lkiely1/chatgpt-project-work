package com.example.springbootapp.controller;

import com.example.springbootapp.dto.HouseholdDTO;
import com.example.springbootapp.model.Household;
import com.example.springbootapp.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {

    @Autowired
    private HouseholdService householdService;

    @GetMapping
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseholdDTO> getHouseholdById(@PathVariable Long id) {
        return householdService.getHouseholdById(id);
    }

    @PostMapping
    public Household createHousehold(@RequestBody Household household) {
        return householdService.createHousehold(household);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable Long id) {
        householdService.deleteHousehold(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
