package com.anonymous63.vrs.services.impl;

import com.anonymous63.vrs.models.dtos.reqDtos.BookingReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.BookingResDto;
import com.anonymous63.vrs.models.entities.Booking;
import com.anonymous63.vrs.repositories.BookingRepo;
import com.anonymous63.vrs.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepo bookingRepo;
    private final ModelMapper mapper;

    public BookingServiceImpl(BookingRepo bookingRepo, ModelMapper mapper) {
        this.bookingRepo = bookingRepo;
        this.mapper = mapper;
    }

    @Override
    public BookingResDto create(BookingReqDto request) {
        Booking booking = mapper.map(request, Booking.class);
        Booking bookingCreated =this.bookingRepo.save(booking);
        return mapper.map(bookingCreated, BookingResDto.class);
    }

    @Override
    public BookingResDto update(Long aLong, BookingReqDto request) {
        return null;
    }

    @Override
    public BookingResDto getById(Long aLong) {
        return null;
    }

    @Override
    public List<BookingResDto> getAll() {
        return List.of();
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void multiDelete(List<Long> longs) {

    }
}
