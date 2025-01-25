package com.anonymous63.vrs.repositories;

import com.anonymous63.vrs.models.entities.VehicleTrimLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleTrimLevelRepo extends JpaRepository<VehicleTrimLevel, Long> {
    Optional<VehicleTrimLevel> findByName(String name);
}
