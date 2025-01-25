package com.anonymous63.vrs.models.dtos.resDtos;

import lombok.Data;

@Data
public class VehicleResDto {
    private Long id;
    private String color;
    private String licensePlate;
    private int manufactureYear;
    private String vehicleRegStatus;
    private String fuelType;
    private String transmission;
}
