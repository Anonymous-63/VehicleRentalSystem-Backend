package com.anonymous63.vrs.models.dtos.resDtos;

import com.anonymous63.vrs.payloads.Views;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleBrandResDto {
    private Long id;
    private String brand;
    private String logo;
    @JsonView(Views.Detailed.class)
    private String description;
}
