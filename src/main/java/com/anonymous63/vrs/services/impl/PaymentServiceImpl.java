package com.anonymous63.vrs.services.impl;

import com.anonymous63.vrs.models.dtos.reqDtos.PaymentReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.PaymentResDto;
import com.anonymous63.vrs.services.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public PaymentResDto create(PaymentReqDto request) {
        return null;
    }

    @Override
    public PaymentResDto update(Long aLong, PaymentReqDto request) {
        return null;
    }

    @Override
    public PaymentResDto getById(Long aLong) {
        return null;
    }

    @Override
    public List<PaymentResDto> getAll() {
        return List.of();
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void multiDelete(List<Long> longs) {

    }
}
