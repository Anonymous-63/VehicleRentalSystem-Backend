package com.anonymous63.vrs.controllers;

import com.anonymous63.vrs.models.dtos.reqDtos.VehicleTrimLevelReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleModelResDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleTrimLevelResDto;
import com.anonymous63.vrs.payloads.responses.ApiResponse;
import com.anonymous63.vrs.services.VehicleTrimLevelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trimLevel")
public class VehicleTrimLevelController implements CrudController<VehicleTrimLevelReqDto, VehicleTrimLevelResDto, Long>{

    private final VehicleTrimLevelService vehicleTrimLevelService;

    public VehicleTrimLevelController(VehicleTrimLevelService vehicleTrimLevelService) {
        this.vehicleTrimLevelService = vehicleTrimLevelService;
    }

    @Override
    public ApiResponse<VehicleTrimLevelResDto> create(VehicleTrimLevelReqDto vehicleTrimLevelReqDto) {
        VehicleTrimLevelResDto createdVehicleTrimLevel = this.vehicleTrimLevelService.create(vehicleTrimLevelReqDto);
        return ApiResponse.<VehicleTrimLevelResDto>builder().status(true).message("Vehicle trim level created successfully.").data(createdVehicleTrimLevel).build();
    }

    @Override
    public ApiResponse<VehicleTrimLevelResDto> update(Long id, VehicleTrimLevelReqDto vehicleTrimLevelReqDto) {
        VehicleTrimLevelResDto updatedVehicleTrimLevel = this.vehicleTrimLevelService.update(id, vehicleTrimLevelReqDto);
        return ApiResponse.<VehicleTrimLevelResDto>builder().status(true).message("Vehicle trim level updated successfully").data(updatedVehicleTrimLevel).build();
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        this.vehicleTrimLevelService.delete(id);
        return ApiResponse.builder().status(true).message("Vehicle trim level deleted successfully.").build();
    }

    @Override
    public ApiResponse<?> multiDelete(List<Long> ids) {
        this.vehicleTrimLevelService.multiDelete(ids);
        return ApiResponse.builder().status(true).message("Vehicle trim levels deleted successfully").build();
    }

    @Override
    public ApiResponse<VehicleTrimLevelResDto> getById(Long id) {
        VehicleTrimLevelResDto retrievedVehicleTrimLevel = this.vehicleTrimLevelService.getById(id);
        return ApiResponse.<VehicleTrimLevelResDto>builder().status(true).message("Vehicle trim level retrieved successfully").data(retrievedVehicleTrimLevel).build();
    }

    @Override
    public ApiResponse<List<VehicleTrimLevelResDto>> getAll() {
        List<VehicleTrimLevelResDto> retrievedVehicleTrimLevels = this.vehicleTrimLevelService.getAll();
        return ApiResponse.<List<VehicleTrimLevelResDto>>builder().status(true).message("Vehicle trim levels retrieved successfully").data(retrievedVehicleTrimLevels).build();
    }
}
