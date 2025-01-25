package com.anonymous63.vrs.repositories;

import com.anonymous63.vrs.models.entities.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleModelRepo extends JpaRepository<VehicleModel, Long> {
    Optional<VehicleModel> findByModel(String model);
}
