package com.harvest.farm.controller.harvest;

import com.harvest.farm.controller.harvest.dto.HarvestDataDTO;
import com.harvest.farm.service.harvest.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("harvest")
public class HarvestController {

    @Autowired
    private HarvestService harvestService;

    @PostMapping
    public ResponseEntity<String> submit(@RequestBody HarvestDataDTO harvestData) {
        harvestService.submit(harvestData);
        return ResponseEntity.status(HttpStatus.CREATED).body("Harvest data submitted successfully");
    }

    @GetMapping("/{farmerId}")
    public ResponseEntity<List<HarvestDataDTO>> getHarvestDataForFarmer(@PathVariable String farmerId) {
        List<HarvestDataDTO> harvestDataList = harvestService.findByFarmerId(farmerId);
        return ResponseEntity.ok(harvestDataList);
    }
}
