package com.anonymous63.vrs.models.dtos.reqDtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VehicleTypeReqDto {
    private Long id;
    private String type;
    private String vehicleClass;
    private String engineType;
    private Long modelId;
}
