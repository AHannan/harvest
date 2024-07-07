package com.harvest.farm.controller.plant.mapper;

import com.harvest.farm.controller.plant.dto.PlantDataDTO;
import com.harvest.farm.dao.model.crop.CropType;
import com.harvest.farm.dao.model.field.Field;
import com.harvest.farm.dao.model.plant.Plant;
import com.harvest.farm.dao.model.season.Season;

import java.util.List;
import java.util.stream.Collectors;

public class PlantMapper {

    public static Plant toEntity(PlantDataDTO dto, Field field, CropType cropType) {
        Plant plant = new Plant();
        plant.setCropType(cropType);
        plant.setExpectedProduct(dto.getExpectedProduct());
        plant.setSeason(Season.valueOf(dto.getSeason()));
        plant.setField(field);
        return plant;
    }

    public static PlantDataDTO toDTO(Plant plant) {
        return PlantDataDTO.builder()
                .expectedProduct(plant.getExpectedProduct())
                .season(plant.getSeason().toString())
                .fieldId(plant.getField().getId())
                .build();
    }

    public static List<PlantDataDTO> mapEntitiesToDTOs(List<Plant> plants) {
        return plants.stream()
                .map(PlantMapper::toDTO)
                .collect(Collectors.toList());
    }
}
