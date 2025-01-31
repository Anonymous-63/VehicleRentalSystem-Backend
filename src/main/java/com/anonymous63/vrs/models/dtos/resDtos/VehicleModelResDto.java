package com.anonymous63.vrs.models.dtos.resDtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleModelResDto {
    private Long id;
    private String model;
    private String description;
}
