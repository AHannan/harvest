package com.harvest.farm.controller.harvest.mapper;

import com.harvest.farm.controller.harvest.dto.HarvestDataDTO;
import com.harvest.farm.dao.model.crop.CropType;
import com.harvest.farm.dao.model.field.Field;
import com.harvest.farm.dao.model.harvest.Harvest;
import com.harvest.farm.dao.model.season.Season;

import java.util.List;
import java.util.stream.Collectors;

public class HarvestMapper {

    public static Harvest toEntity(HarvestDataDTO dto, Field field, CropType cropType) {
        var result = new Harvest();
        result.setCropType(cropType);
        result.setActualProduct(dto.getActualProduct());
        result.setSeason(Season.valueOf(dto.getSeason()));
        result.setField(field);
        return result;
    }

    public static HarvestDataDTO toDTO(Harvest harvest) {
        return HarvestDataDTO.builder()
                .actualProduct(harvest.getActualProduct())
                .season(harvest.getSeason().toString())
                .fieldId(harvest.getField().getId())
                .build();
    }

    public static List<HarvestDataDTO> mapEntitiesToDTOs(List<Harvest> harvests) {
        return harvests.stream()
                .map(HarvestMapper::toDTO)
                .collect(Collectors.toList());
    }
}
