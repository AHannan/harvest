package com.harvest.farm.service.report;

import com.harvest.farm.dao.model.harvest.Harvest;
import com.harvest.farm.dao.model.plant.Plant;
import com.harvest.farm.dao.repository.harvest.HarvestRepository;
import com.harvest.farm.dao.repository.plant.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private HarvestRepository harvestRepository;

    public String generateFarmReport(String farmerId) {
        List<Plant> plantedData = plantRepository.findByFieldFarmerId(farmerId);
        List<Harvest> harvestedData = harvestRepository.findByFieldFarmerId(farmerId);

        double totalExpected = plantedData.stream().mapToDouble(Plant::getExpectedProduct).sum();
        double totalActual = harvestedData.stream().mapToDouble(Harvest::getActualProduct).sum();

        StringBuilder report = new StringBuilder();
        report.append("Farm Report for Farmer ").append(farmerId).append("\n");
        report.append("Total Expected Product: ").append(totalExpected).append(" tons\n");
        report.append("Total Actual Product: ").append(totalActual).append(" tons\n");

        return report.toString();
    }

    public String generateCropReport(String cropTypeId) {
        List<Plant> plantedData = plantRepository.findByCropTypeId(cropTypeId);
        List<Harvest> harvestedData = harvestRepository.findByCropTypeId(cropTypeId);

        double totalExpected = plantedData.stream().mapToDouble(Plant::getExpectedProduct).sum();
        double totalActual = harvestedData.stream().mapToDouble(Harvest::getActualProduct).sum();

        StringBuilder report = new StringBuilder();
        report.append("Crop Report for Crop Type ").append(cropTypeId).append("\n");
        report.append("Total Expected Product: ").append(totalExpected).append(" tons\n");
        report.append("Total Actual Product: ").append(totalActual).append(" tons\n");

        return report.toString();
    }
}
