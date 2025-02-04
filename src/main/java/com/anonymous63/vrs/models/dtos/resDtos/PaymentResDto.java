package com.anonymous63.vrs.models.dtos.resDtos;

import com.anonymous63.vrs.models.entities.Booking;
import com.anonymous63.vrs.models.entities.Payment;
import com.anonymous63.vrs.models.entities.User;
import com.anonymous63.vrs.payloads.enums.PaymentType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class PaymentResDto {
    private Long paymentId;
    private PaymentType paymentType;
    private Long transactionId;
    private String paymentDate;
    private String paymentAmount;
    private Booking booking;
    private User user;
}
