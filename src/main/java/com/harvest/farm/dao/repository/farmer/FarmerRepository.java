package com.harvest.farm.dao.repository.farmer;

import com.harvest.farm.dao.model.farmer.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer, String> {
}
