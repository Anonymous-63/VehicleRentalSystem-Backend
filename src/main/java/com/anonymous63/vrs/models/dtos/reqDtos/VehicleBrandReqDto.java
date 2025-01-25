package com.anonymous63.vrs.models.dtos.reqDtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VehicleBrandReqDto {
    private Long id;
    private String brand;
    private String logo;
    private String description;
    private List<VehicleModelReqDto> vehicleModels;
}
