package com.harvest.farm.dao.repository.crop;

import com.harvest.farm.dao.model.crop.CropType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropTypeRepository extends JpaRepository<CropType, String> {
}
