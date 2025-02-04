package com.anonymous63.vrs.repositories;

import com.anonymous63.vrs.models.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
}
