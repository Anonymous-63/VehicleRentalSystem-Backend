package com.anonymous63.vrs.models.dtos.reqDtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleReqDto {

    private Long id;
    private String color;
    private String licensePlate;
    private int manufactureYear;
    private String vehicleRegStatus;
    private String fuelType;
    private String transmission;
    private UserReqDto userReqDto;
}
