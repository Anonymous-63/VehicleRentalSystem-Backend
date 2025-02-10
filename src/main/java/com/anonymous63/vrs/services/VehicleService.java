package com.anonymous63.vrs.services;

import com.anonymous63.vrs.models.dtos.reqDtos.VehicleReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleResDto;

import java.util.List;

public interface VehicleService extends CrudService<VehicleReqDto, VehicleResDto, Long> {
    List<VehicleResDto> getAllAvailableVehicle();
}
