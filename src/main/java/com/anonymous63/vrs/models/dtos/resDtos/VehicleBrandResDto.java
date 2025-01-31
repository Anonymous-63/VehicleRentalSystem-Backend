package com.anonymous63.vrs.models.dtos.resDtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleBrandResDto {
    private Long id;
    private String brand;
    private String logo;
    private String description;
}
