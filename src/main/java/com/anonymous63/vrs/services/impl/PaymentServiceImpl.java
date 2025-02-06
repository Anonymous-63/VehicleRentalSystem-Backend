package com.anonymous63.vrs.services.impl;

import com.anonymous63.vrs.exceptions.ResourceNotFoundException;
import com.anonymous63.vrs.models.dtos.reqDtos.PaymentReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.BookingResDto;
import com.anonymous63.vrs.models.dtos.resDtos.PaymentResDto;
import com.anonymous63.vrs.models.entities.Booking;
import com.anonymous63.vrs.models.entities.Payment;
import com.anonymous63.vrs.models.entities.User;
import com.anonymous63.vrs.repositories.BookingRepo;
import com.anonymous63.vrs.repositories.PaymentRepo;
import com.anonymous63.vrs.repositories.UserRepo;
import com.anonymous63.vrs.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepo;
    private final BookingRepo bookingRepo;
    private final UserRepo userRepo;
    private final ModelMapper mapper;

    public PaymentServiceImpl(PaymentRepo paymentRepo, BookingRepo bookingRepo, UserRepo userRepo, ModelMapper mapper) {
        this.paymentRepo = paymentRepo;
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public PaymentResDto create(PaymentReqDto request) {
        Booking booking = this.bookingRepo.findById(request.getBookingId()).orElseThrow(() -> new ResourceNotFoundException(Booking.class.getSimpleName(), "id", String.valueOf(request.getBookingId())));
        User user = this.userRepo.findById(request.getUserId()).orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), "id", String.valueOf(request.getUserId())));
        Payment payment = this.mapper.map(request, Payment.class);
        payment.setBooking(booking);
        payment.setUser(user);
        Payment createdPayment = this.paymentRepo.save(payment);
        return this.mapper.map(createdPayment, PaymentResDto.class);
    }

    @Override
    public PaymentResDto update(Long id, PaymentReqDto request) {
        Payment payment = this.paymentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Payment.class.getSimpleName(), "id", String.valueOf(id)));
        payment.setPaymentAmount(request.getPaymentAmount());
        Payment updatedPayment = this.paymentRepo.save(payment);
        return this.mapper.map(updatedPayment, PaymentResDto.class);
    }

    @Override
    public PaymentResDto getById(Long id) {
        Payment payment = this.paymentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Payment.class.getSimpleName(), "id", String.valueOf(id)));
        return this.mapper.map(payment, PaymentResDto.class);
    }

    @Override
    public List<PaymentResDto> getAll() {
        List<Payment> payments = this.paymentRepo.findAll();
        return payments.stream().map(payment -> mapper.map(payment, PaymentResDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Payment payment = this.paymentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Payment.class.getSimpleName(), "id", String.valueOf(id)));

        this.paymentRepo.delete(payment);
    }

    @Override
    public void multiDelete(List<Long> ids) {
        List<Payment> payments = this.paymentRepo.findAllById(ids);
        this.paymentRepo.deleteAll(payments);
    }
}
