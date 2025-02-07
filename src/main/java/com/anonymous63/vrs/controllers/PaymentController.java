package com.anonymous63.vrs.controllers;

import com.anonymous63.vrs.models.dtos.reqDtos.PaymentReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.PaymentResDto;
import com.anonymous63.vrs.payloads.responses.ApiResponse;
import com.anonymous63.vrs.services.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController implements CrudController<PaymentReqDto, PaymentResDto, Long> {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public ApiResponse<PaymentResDto> create(PaymentReqDto paymentReqDto) {
        PaymentResDto createdPayment = this.paymentService.create(paymentReqDto);
        return ApiResponse.<PaymentResDto>builder().status(true).message("Payment successful.").data(createdPayment).build();
    }

    @Override
    public ApiResponse<PaymentResDto> update(Long id, PaymentReqDto paymentReqDto) {
        PaymentResDto updatedPayment = this.paymentService.update(id, paymentReqDto);
        return ApiResponse.<PaymentResDto>builder().status(true).message("Payment updated successfully").data(updatedPayment).build();
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        this.paymentService.delete(id);
        return ApiResponse.builder().status(true).message("Payment deleted successfully.").build();
    }

    @Override
    public ApiResponse<?> multiDelete(List<Long> ids) {
        this.paymentService.multiDelete(ids);
        return ApiResponse.builder().status(true).message("Payments deleted successfully").build();
    }

    @Override
    public ApiResponse<PaymentResDto> getById(Long id) {
        PaymentResDto retrievedPayment = this.paymentService.getById(id);
        return ApiResponse.<PaymentResDto>builder().status(true).message("Payment retrieved successfully").data(retrievedPayment).build();
    }

    @Override
    public ApiResponse<List<PaymentResDto>> getAll() {
        List<PaymentResDto> retrievedPayments = this.paymentService.getAll();
        return ApiResponse.<List<PaymentResDto>>builder().status(true).message("Payments fetched successfully").data(retrievedPayments).build();
    }
}
