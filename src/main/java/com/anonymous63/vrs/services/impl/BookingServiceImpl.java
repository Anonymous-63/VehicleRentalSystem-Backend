package com.anonymous63.vrs.services.impl;

import com.anonymous63.vrs.exceptions.ResourceNotFoundException;
import com.anonymous63.vrs.models.dtos.reqDtos.BookingReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.BookingResDto;
import com.anonymous63.vrs.models.entities.Booking;
import com.anonymous63.vrs.models.entities.User;
import com.anonymous63.vrs.models.entities.Vehicle;
import com.anonymous63.vrs.models.entities.VehicleBrand;
import com.anonymous63.vrs.payloads.enums.BookingStatus;
import com.anonymous63.vrs.repositories.BookingRepo;
import com.anonymous63.vrs.repositories.UserRepo;
import com.anonymous63.vrs.repositories.VehicleRepo;
import com.anonymous63.vrs.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepo bookingRepo;
    private final UserRepo userRepo;
    private final VehicleRepo vehicleRepo;
    private final ModelMapper mapper;

    public BookingServiceImpl(BookingRepo bookingRepo, UserRepo userRepo, VehicleRepo vehicleRepo, ModelMapper mapper) {
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.vehicleRepo = vehicleRepo;
        this.mapper = mapper;
    }

    @Override
    public BookingResDto create(BookingReqDto request) {
        User user = this.userRepo.findById(request.getUserId()).orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), "id", String.valueOf(request.getUserId())));
        Vehicle vehicle = this.vehicleRepo.findById(request.getVehicleId()).orElseThrow(() -> new ResourceNotFoundException(Vehicle.class.getSimpleName(), "id", String.valueOf(request.getVehicleId())));
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setVehicle(vehicle);
        booking.setFromDate(request.getFromDate());
        booking.setToDate(request.getToDate());
        booking.setDuration(request.getDuration());
        booking.setPrice(request.getPrice());
        booking.setBookingStatus(BookingStatus.PENDING);
        Booking bookingCreated = this.bookingRepo.save(booking);
        return mapper.map(bookingCreated, BookingResDto.class);
    }

    @Override
    public BookingResDto update(Long id, BookingReqDto request) {
        Booking booking = this.bookingRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Booking.class.getSimpleName(), "id", String.valueOf(id)));

        User user = this.userRepo.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), "id", String.valueOf(request.getUserId())));

        Vehicle vehicle = this.vehicleRepo.findById(request.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException(Vehicle.class.getSimpleName(), "id", String.valueOf(request.getVehicleId())));

        booking.setUser(user);
        booking.setVehicle(vehicle);
        booking.setFromDate(request.getFromDate());
        booking.setToDate(request.getToDate());
        booking.setDuration(request.getDuration());
        booking.setPrice(request.getPrice());

        Booking updatedBooking = this.bookingRepo.save(booking);
        return mapper.map(updatedBooking, BookingResDto.class);
    }

    @Override
    public BookingResDto getById(Long id) {
        Booking booking = this.bookingRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Booking.class.getSimpleName(), "id", String.valueOf(id)));

        return mapper.map(booking, BookingResDto.class);
    }

    @Override
    public List<BookingResDto> getAll() {
        List<Booking> bookings = this.bookingRepo.findAll();
        return bookings.stream().map(booking -> mapper.map(booking, BookingResDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Booking booking = this.bookingRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Booking.class.getSimpleName(), "id", String.valueOf(id)));

        this.bookingRepo.delete(booking);
    }

    @Override
    public void multiDelete(List<Long> ids) {
        List<Booking> bookings = this.bookingRepo.findAllById(ids);
        this.bookingRepo.deleteAll(bookings);
    }
}
