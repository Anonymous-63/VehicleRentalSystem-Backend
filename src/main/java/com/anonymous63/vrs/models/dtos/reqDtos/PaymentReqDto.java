package com.anonymous63.vrs.models.dtos.reqDtos;

import com.anonymous63.vrs.models.entities.Booking;
import com.anonymous63.vrs.models.entities.Payment;
import com.anonymous63.vrs.models.entities.User;
import com.anonymous63.vrs.payloads.enums.PaymentType;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentReqDto {
    private Long bookingId;
    private Long userId;
    private String paymentAmount;
}
