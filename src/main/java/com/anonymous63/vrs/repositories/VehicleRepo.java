package com.anonymous63.vrs.repositories;

import com.anonymous63.vrs.models.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v WHERE v.id NOT IN " +
            "(SELECT b.vehicle.id FROM Booking b WHERE b.bookingStatus = 'APPROVED')")
    List<Vehicle> findAllAvailableVehicles();
}
