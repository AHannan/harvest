package com.harvest.farm.controller.plant.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlantDataDTO {
    private Long id;
    private String cropTypeId;
    private Double expectedProduct;
    private String season;
    private String fieldId;

}
