package com.anonymous63.vrs.models.dtos.resDtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleTypeResDto {
    private Long id;
    private String type;
    private String vehicleClass;
    private String engineType;
    private VehicleModelResDto model;
}
