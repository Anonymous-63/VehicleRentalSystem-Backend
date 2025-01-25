package com.anonymous63.vrs.repositories;

import com.anonymous63.vrs.models.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
}
