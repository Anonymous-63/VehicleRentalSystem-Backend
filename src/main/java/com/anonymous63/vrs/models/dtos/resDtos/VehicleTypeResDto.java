package com.anonymous63.vrs.models.dtos.resDtos;

import lombok.Data;

@Data
public class VehicleTypeResDto {
    private Long id;
    private String type;
    private String vehicleClass;
    private String engineType;
    private VehicleModelResDto vehicleModel;
}
