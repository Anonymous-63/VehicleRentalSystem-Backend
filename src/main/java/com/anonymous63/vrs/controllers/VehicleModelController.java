package com.anonymous63.vrs.controllers;

import com.anonymous63.vrs.models.dtos.reqDtos.VehicleModelReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleModelResDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleResDto;
import com.anonymous63.vrs.payloads.responses.ApiResponse;
import com.anonymous63.vrs.services.VehicleModelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/model")
public class VehicleModelController implements CrudController<VehicleModelReqDto, VehicleModelResDto, Long> {

    private final VehicleModelService vehicleModelService;

    public VehicleModelController(VehicleModelService vehicleModelService) {
        this.vehicleModelService = vehicleModelService;
    }

    @Override
    public ApiResponse<VehicleModelResDto> create(VehicleModelReqDto vehicleModelReqDto) {
        VehicleModelResDto createdVehicleModel = this.vehicleModelService.create(vehicleModelReqDto);
        return ApiResponse.<VehicleModelResDto>builder().status(true).message("Vehicle model created successfully.").data(createdVehicleModel).build();
    }

    @Override
    public ApiResponse<VehicleModelResDto> update(Long id, VehicleModelReqDto vehicleModelReqDto) {
        VehicleModelResDto updatedVehicleModel = this.vehicleModelService.update(id, vehicleModelReqDto);
        return ApiResponse.<VehicleModelResDto>builder().status(true).message("Vehicle model updated successfully").data(updatedVehicleModel).build();
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        this.vehicleModelService.delete(id);
        return ApiResponse.builder().status(true).message("Vehicle model deleted successfully.").build();
    }

    @Override
    public ApiResponse<?> multiDelete(List<Long> ids) {
        this.vehicleModelService.multiDelete(ids);
        return ApiResponse.builder().status(true).message("Vehicle models deleted successfully").build();
    }

    @Override
    public ApiResponse<VehicleModelResDto> getById(Long id) {
        VehicleModelResDto retrievedVehicleModel = this.vehicleModelService.getById(id);
        return ApiResponse.<VehicleModelResDto>builder().status(true).message("Vehicle retrieved successfully").data(retrievedVehicleModel).build();
    }

    @Override
    public ApiResponse<List<VehicleModelResDto>> getAll() {
        List<VehicleModelResDto> retrievedVehicleModels = this.vehicleModelService.getAll();
        return ApiResponse.<List<VehicleModelResDto>>builder().status(true).message("Vehicle models retrieved successfully").data(retrievedVehicleModels).build();
    }
}
