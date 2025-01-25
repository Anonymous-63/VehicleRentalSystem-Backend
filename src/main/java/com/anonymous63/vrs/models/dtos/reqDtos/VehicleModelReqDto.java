package com.anonymous63.vrs.models.dtos.reqDtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VehicleModelReqDto {
    private Long id;
    private String model;
    private String description;
    private VehicleBrandReqDto vehicleBrand;
    private List<VehicleTypeReqDto> vehicleTypes;
}
