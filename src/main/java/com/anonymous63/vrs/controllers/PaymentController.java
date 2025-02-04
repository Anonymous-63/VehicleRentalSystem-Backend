package com.anonymous63.vrs.controllers;

import com.anonymous63.vrs.models.dtos.reqDtos.PaymentReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.PaymentResDto;
import com.anonymous63.vrs.payloads.responses.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController implements CrudController<PaymentReqDto, PaymentResDto, Long> {
    @Override
    public ApiResponse<PaymentResDto> create(PaymentReqDto paymentReqDto) {
        return null;
    }

    @Override
    public ApiResponse<PaymentResDto> update(Long aLong, PaymentReqDto paymentReqDto) {
        return null;
    }

    @Override
    public ApiResponse<?> delete(Long aLong) {
        return null;
    }

    @Override
    public ApiResponse<?> multiDelete(List<Long> longs) {
        return null;
    }

    @Override
    public ApiResponse<PaymentResDto> getById(Long aLong) {
        return null;
    }

    @Override
    public ApiResponse<List<PaymentResDto>> getAll() {
        return null;
    }
}
