package com.anonymous63.vrs.controllers;

import com.anonymous63.vrs.models.dtos.reqDtos.BookingReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.BookingResDto;
import com.anonymous63.vrs.payloads.responses.ApiResponse;
import com.anonymous63.vrs.services.BookingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController implements CrudController<BookingReqDto, BookingResDto, Long> {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public ApiResponse<BookingResDto> create(BookingReqDto bookingReqDto) {
        BookingResDto createdBooking = this.bookingService.create(bookingReqDto);
        return ApiResponse.<BookingResDto>builder().status(true).message("Booking created successfully.").data(createdBooking).build();
    }

    @Override
    public ApiResponse<BookingResDto> update(Long aLong, BookingReqDto bookingReqDto) {
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
    public ApiResponse<BookingResDto> getById(Long aLong) {
        return null;
    }

    @Override
    public ApiResponse<List<BookingResDto>> getAll() {
        return null;
    }
}
