package com.anonymous63.vrs.models.dtos.resDtos;

import com.anonymous63.vrs.payloads.Views;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleModelResDto {
    private Long id;
    private String model;
    private String description;
    @JsonView(Views.Public.class)
    private VehicleBrandResDto brand;
}
