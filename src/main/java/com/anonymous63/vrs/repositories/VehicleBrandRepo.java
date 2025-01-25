package com.anonymous63.vrs.repositories;

import com.anonymous63.vrs.models.entities.VehicleBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleBrandRepo extends JpaRepository<VehicleBrand, Long> {
    Optional<VehicleBrand> findByBrand(String brand);
}
