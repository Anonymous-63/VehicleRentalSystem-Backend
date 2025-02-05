package com.anonymous63.vrs.models.dtos.reqDtos;

import com.anonymous63.vrs.models.dtos.resDtos.VehicleBrandResDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleModelResDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleTypeResDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleReqDto {

    private Long id;
    private Long brandId;
    private Long modelId;
    private Long typeId;
    private String vehicleImg;
    private String color;
    private String licensePlate;
    private int manufactureYear;
    private String fuelType;
    private String transmission;
}
