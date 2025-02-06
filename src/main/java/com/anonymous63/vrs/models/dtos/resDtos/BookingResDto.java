package com.anonymous63.vrs.models.dtos.resDtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResDto {
    private Long bookingId;
    private UserResDto user;
    private VehicleResDto vehicle;
    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;
    private Double price;
    private String bookingStatus;
}
