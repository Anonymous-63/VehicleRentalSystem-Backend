package com.anonymous63.vrs.repositories;

import com.anonymous63.vrs.models.entities.Booking;
import com.anonymous63.vrs.models.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
    List<Payment> findByUserId(Long userId);
}
