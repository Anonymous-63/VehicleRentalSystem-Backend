package com.anonymous63.vrs.repositories;

import com.anonymous63.vrs.models.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {
}
