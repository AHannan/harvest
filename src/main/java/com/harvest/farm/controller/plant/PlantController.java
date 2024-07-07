package com.harvest.farm.controller.plant;

import com.harvest.farm.controller.plant.dto.PlantDataDTO;
import com.harvest.farm.service.plant.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @PostMapping
    public ResponseEntity<String> submitPlantData(@RequestBody PlantDataDTO plantData) {
        plantService.submit(plantData);
        return ResponseEntity.status(HttpStatus.CREATED).body("Plant data submitted successfully");
    }

    @GetMapping("/{farmId}")
    public ResponseEntity<List<PlantDataDTO>> getPlantDataForFarm(@PathVariable String farmId) {
        List<PlantDataDTO> plantDataList = plantService.findByFarmer(farmId);
        return ResponseEntity.ok(plantDataList);
    }
}