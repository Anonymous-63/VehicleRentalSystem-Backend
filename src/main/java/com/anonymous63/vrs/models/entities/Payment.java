package com.anonymous63.vrs.models.entities;

import com.anonymous63.vrs.payloads.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    @ManyToOne
    private Booking booking;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    private Long transactionId;
    @CreationTimestamp
    private String paymentDate;
    private Double paymentAmount;
}
