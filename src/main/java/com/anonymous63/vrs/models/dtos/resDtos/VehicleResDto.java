package com.anonymous63.vrs.models.dtos.resDtos;

import com.anonymous63.vrs.models.entities.VehicleBrand;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleResDto {
    private Long id;
    private VehicleBrandResDto brand;
    private VehicleModelResDto model;
    private VehicleTypeResDto type;
    private String color;
    private String licensePlate;
    private int manufactureYear;
    private String vehicleRegStatus;
    private String fuelType;
    private String transmission;
}
