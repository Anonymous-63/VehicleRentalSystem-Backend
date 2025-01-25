package com.anonymous63.vrs.repositories;

import com.anonymous63.vrs.models.entities.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleTypeRepo extends JpaRepository<VehicleType, Long> {
    Optional<VehicleType> findByType(String name);
}
