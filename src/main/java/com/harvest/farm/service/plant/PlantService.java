package com.harvest.farm.service.plant;

import com.harvest.farm.controller.plant.dto.PlantDataDTO;
import com.harvest.farm.controller.plant.mapper.PlantMapper;
import com.harvest.farm.dao.model.plant.Plant;
import com.harvest.farm.dao.repository.crop.CropTypeRepository;
import com.harvest.farm.dao.repository.field.FieldRepository;
import com.harvest.farm.dao.repository.plant.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantedRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private CropTypeRepository cropTypeRepository;

    public void submit(PlantDataDTO plantData) {
        var plant = PlantMapper.toEntity(
                plantData,
                fieldRepository.findById(plantData.getFieldId()).orElse(null),
                cropTypeRepository.findById(plantData.getCropTypeId()).orElse(null)
        );
        plantedRepository.save(plant);
    }

    public List<PlantDataDTO> findByFarmer(String farmId) {
        List<Plant> plantedList = plantedRepository.findByFieldFarmerId(farmId);
        List<PlantDataDTO> plantedDataList = PlantMapper.mapEntitiesToDTOs(plantedList);

        return plantedDataList;
    }
}
