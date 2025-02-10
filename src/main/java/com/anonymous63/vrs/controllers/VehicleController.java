package com.anonymous63.vrs.controllers;

import com.anonymous63.vrs.models.dtos.reqDtos.VehicleReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleBrandResDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleResDto;
import com.anonymous63.vrs.payloads.responses.ApiResponse;
import com.anonymous63.vrs.services.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController implements CrudController<VehicleReqDto, VehicleResDto, Long> {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public ApiResponse<VehicleResDto> create(VehicleReqDto vehicleReqDto) {
        VehicleResDto createdVehicle = this.vehicleService.create(vehicleReqDto);
        return ApiResponse.<VehicleResDto>builder().status(true).message("Vehicle created successfully.").data(createdVehicle).build();
    }

    @Override
    public ApiResponse<VehicleResDto> update(Long id, VehicleReqDto vehicleReqDto) {
        VehicleResDto updatedVehicle = this.vehicleService.update(id, vehicleReqDto);
        return ApiResponse.<VehicleResDto>builder().status(true).message("Vehicle updated successfully").data(updatedVehicle).build();
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        this.vehicleService.delete(id);
        return ApiResponse.builder().status(true).message("Vehicle deleted successfully.").build();
    }

    @Override
    public ApiResponse<?> multiDelete(List<Long> ids) {
        this.vehicleService.multiDelete(ids);
        return ApiResponse.builder().status(true).message("Vehicles deleted successfully").build();
    }

    @Override
    public ApiResponse<VehicleResDto> getById(Long id) {
        VehicleResDto retrievedVehicle = this.vehicleService.getById(id);
        return ApiResponse.<VehicleResDto>builder().status(true).message("Vehicle retrieved successfully").data(retrievedVehicle).build();
    }

    @Override
    public ApiResponse<List<VehicleResDto>> getAll() {
        List<VehicleResDto> retrievedVehicles = this.vehicleService.getAll();
        return ApiResponse.<List<VehicleResDto>>builder().status(true).message("Vehicles retrieved successfully").data(retrievedVehicles).build();
    }

    @GetMapping("/available")
    public ApiResponse<List<VehicleResDto>> getAllAvailableVehicle() {
        List<VehicleResDto> availableVehicles = this.vehicleService.getAllAvailableVehicle();
        return ApiResponse.<List<VehicleResDto>>builder().status(true).message("Available vehicles fetched successfully.").data(availableVehicles).build();
    }
}
