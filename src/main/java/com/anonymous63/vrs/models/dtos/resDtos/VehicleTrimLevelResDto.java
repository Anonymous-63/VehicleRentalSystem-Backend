package com.anonymous63.vrs.models.dtos.resDtos;

import lombok.Data;

@Data
public class VehicleTrimLevelResDto {
    private Long id;
    private String name;
    private String description;
    private VehicleTypeResDto vehicleType;
}
