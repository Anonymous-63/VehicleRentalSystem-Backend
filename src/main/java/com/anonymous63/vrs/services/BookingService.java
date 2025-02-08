package com.anonymous63.vrs.services;

import com.anonymous63.vrs.models.dtos.reqDtos.BookingReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.BookingResDto;

import java.util.List;

public interface BookingService extends CrudService<BookingReqDto, BookingResDto, Long> {
    List<BookingResDto> getBookingsByUserId(Long userId);
}
