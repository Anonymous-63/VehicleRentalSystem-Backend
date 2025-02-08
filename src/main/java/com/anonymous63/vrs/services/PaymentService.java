package com.anonymous63.vrs.services;

import com.anonymous63.vrs.models.dtos.reqDtos.PaymentReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.BookingResDto;
import com.anonymous63.vrs.models.dtos.resDtos.PaymentResDto;

import java.util.List;

public interface PaymentService extends CrudService<PaymentReqDto, PaymentResDto, Long>{
    List<PaymentResDto> getPaymentsByUserId(Long userId);
}
