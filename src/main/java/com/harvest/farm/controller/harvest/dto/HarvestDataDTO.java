package com.harvest.farm.controller.harvest.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HarvestDataDTO {
    private Long id;
    private Double actualProduct;
    private String cropTypeId;
    private String season;
    private String fieldId;

}
