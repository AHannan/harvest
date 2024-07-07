package com.harvest.farm.service.harvest;

import com.harvest.farm.controller.harvest.dto.HarvestDataDTO;
import com.harvest.farm.controller.harvest.mapper.HarvestMapper;
import com.harvest.farm.dao.model.harvest.Harvest;
import com.harvest.farm.dao.model.season.Season;
import com.harvest.farm.dao.repository.crop.CropTypeRepository;
import com.harvest.farm.dao.repository.field.FieldRepository;
import com.harvest.farm.dao.repository.harvest.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarvestService {

    @Autowired
    private HarvestRepository harvestRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private CropTypeRepository cropTypeRepository;

    public void submit(HarvestDataDTO harvestData) {
        if (harvestRepository.existsBySeasonAndFieldIdAndCropTypeId(
                Season.valueOf(harvestData.getSeason()),
                harvestData.getFieldId(),
                harvestData.getCropTypeId())) {
            throw new RuntimeException("Duplicate entry: Harvest data already exists for the given season, field, and crop type");
        }

        var harvest = HarvestMapper.toEntity(
                harvestData,
                fieldRepository.findById(harvestData.getFieldId()).orElse(null),
                cropTypeRepository.findById(harvestData.getCropTypeId()).orElse(null)
        );
        harvestRepository.save(harvest);
    }


    public List<HarvestDataDTO> findByFarmerId(String farmerId) {
        List<Harvest> harvestList = harvestRepository.findByFieldFarmerId(farmerId);
        return HarvestMapper.mapEntitiesToDTOs(harvestList);
    }
}
