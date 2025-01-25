package com.anonymous63.vrs.models.dtos.reqDtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleTrimLevelReqDto {
    private Long id;
    private String name;
    private String description;
    private VehicleTypeReqDto vehicleType;
}
