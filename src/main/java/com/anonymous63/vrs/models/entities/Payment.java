package com.anonymous63.vrs.models.entities;

import com.anonymous63.vrs.payloads.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private PaymentType paymentType;
    private Long transactionId;
    private String paymentDate;
    private String paymentAmount;
    @ManyToOne
    private Booking booking;
    @ManyToOne
    private User user;
}
