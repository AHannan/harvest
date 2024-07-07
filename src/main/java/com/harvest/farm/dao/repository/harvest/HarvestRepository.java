package com.harvest.farm.dao.repository.harvest;

import com.harvest.farm.dao.model.harvest.Harvest;
import com.harvest.farm.dao.model.season.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HarvestRepository extends JpaRepository<Harvest, String> {
    boolean existsBySeasonAndFieldIdAndCropTypeId(Season season, String fieldId, String cropTypeId);
    List<Harvest> findByFieldFarmerId(String farmerId);
    List<Harvest> findByCropTypeId(String cropType);
}
