package com.harvest.farm.dao.repository.field;

import com.harvest.farm.dao.model.field.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, String> {
}
