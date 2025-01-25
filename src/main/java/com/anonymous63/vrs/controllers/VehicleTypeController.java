package com.anonymous63.vrs.controllers;

import com.anonymous63.vrs.models.dtos.reqDtos.VehicleTypeReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleTypeResDto;
import com.anonymous63.vrs.payloads.responses.ApiResponse;
import com.anonymous63.vrs.services.VehicleTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class VehicleTypeController implements CrudController<VehicleTypeReqDto, VehicleTypeResDto, Long> {

    private final VehicleTypeService vehicleTypeService;

    public VehicleTypeController(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @Override
    public ApiResponse<VehicleTypeResDto> create(VehicleTypeReqDto vehicleTypeReqDto) {
        VehicleTypeResDto createdVehicleType = this.vehicleTypeService.create(vehicleTypeReqDto);
        return ApiResponse.<VehicleTypeResDto>builder().status(true).message("Vehicle type created successfully.").data(createdVehicleType).build();
    }

    @Override
    public ApiResponse<VehicleTypeResDto> update(Long id, VehicleTypeReqDto vehicleTypeReqDto) {
        VehicleTypeResDto updatedVehicleType = this.vehicleTypeService.update(id, vehicleTypeReqDto);
        return ApiResponse.<VehicleTypeResDto>builder().status(true).message("Vehicle type updated successfully").data(updatedVehicleType).build();
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        this.vehicleTypeService.delete(id);
        return ApiResponse.builder().status(true).message("Vehicle type deleted successfully.").build();
    }

    @Override
    public ApiResponse<?> multiDelete(List<Long> ids) {
        this.vehicleTypeService.multiDelete(ids);
        return ApiResponse.builder().status(true).message("Vehicle types deleted successfully").build();
    }

    @Override
    public ApiResponse<VehicleTypeResDto> getById(Long id) {
        VehicleTypeResDto retrievedVehicleType = this.vehicleTypeService.getById(id);
        return ApiResponse.<VehicleTypeResDto>builder().status(true).message("Vehicle type retrieved successfully").data(retrievedVehicleType).build();
    }

    @Override
    public ApiResponse<List<VehicleTypeResDto>> getAll() {
        List<VehicleTypeResDto> retrievedVehicleTypes = this.vehicleTypeService.getAll();
        return ApiResponse.<List<VehicleTypeResDto>>builder().status(true).message("Vehicle types retrieved successfully").data(retrievedVehicleTypes).build();
    }
}
