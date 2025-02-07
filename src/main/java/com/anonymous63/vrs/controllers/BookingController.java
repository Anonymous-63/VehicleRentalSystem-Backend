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
        return ApiResponse.<BookingResDto>builder().status(true).message("Booking successful.").data(createdBooking).build();
    }

    @Override
    public ApiResponse<BookingResDto> update(Long id, BookingReqDto bookingReqDto) {
        BookingResDto updatedBooking = this.bookingService.update(id, bookingReqDto);
        return ApiResponse.<BookingResDto>builder().status(true).message("Booking updated successfully").data(updatedBooking).build();
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        this.bookingService.delete(id);
        return ApiResponse.builder().status(true).message("Booking deleted successfully.").build();
    }

    @Override
    public ApiResponse<?> multiDelete(List<Long> ids) {
        this.bookingService.multiDelete(ids);
        return ApiResponse.builder().status(true).message("Bookings deleted successfully").build();
    }

    @Override
    public ApiResponse<BookingResDto> getById(Long id) {
        BookingResDto retrievedBooking = this.bookingService.getById(id);
        return ApiResponse.<BookingResDto>builder().status(true).message("Booking retrieved successfully").data(retrievedBooking).build();
    }

    @Override
    public ApiResponse<List<BookingResDto>> getAll() {
        List<BookingResDto> retrievedBookings = this.bookingService.getAll();
        return ApiResponse.<List<BookingResDto>>builder().status(true).message("Bookings fetched successfully").data(retrievedBookings).build();
    }
}
