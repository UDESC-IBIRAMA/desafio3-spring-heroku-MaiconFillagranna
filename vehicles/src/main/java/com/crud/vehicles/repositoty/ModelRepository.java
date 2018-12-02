package com.crud.vehicles.repositoty;

import com.crud.vehicles.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, UUID> {
}
