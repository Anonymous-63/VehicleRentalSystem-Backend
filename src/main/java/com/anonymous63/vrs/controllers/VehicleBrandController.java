package com.anonymous63.vrs.controllers;

import com.anonymous63.vrs.models.dtos.reqDtos.VehicleBrandReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleBrandResDto;
import com.anonymous63.vrs.payloads.responses.ApiResponse;
import com.anonymous63.vrs.services.VehicleBrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class VehicleBrandController implements CrudController<VehicleBrandReqDto, VehicleBrandResDto, Long> {

    private final VehicleBrandService vehicleBrandService;

    public VehicleBrandController(VehicleBrandService vehicleBrandService) {
        this.vehicleBrandService = vehicleBrandService;
    }

    @Override
    public ApiResponse<VehicleBrandResDto> create(VehicleBrandReqDto vehicleBrandReqDto) {
        VehicleBrandResDto createdVehicleBrand = this.vehicleBrandService.create(vehicleBrandReqDto);
        return ApiResponse.<VehicleBrandResDto>builder().status(true).message("Vehicle brand created successfully.").data(createdVehicleBrand).build();
    }

    @Override
    public ApiResponse<VehicleBrandResDto> update(Long id, VehicleBrandReqDto vehicleBrandReqDto) {
        VehicleBrandResDto updatedVehicleBrand = this.vehicleBrandService.update(id, vehicleBrandReqDto);
        return ApiResponse.<VehicleBrandResDto>builder().status(true).message("Vehicle brand updated successfully").data(updatedVehicleBrand).build();
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        this.vehicleBrandService.delete(id);
        return ApiResponse.builder().status(true).message("Vehicle brand deleted successfully.").build();
    }

    @Override
    public ApiResponse<?> multiDelete(List<Long> ids) {
        this.vehicleBrandService.multiDelete(ids);
        return ApiResponse.builder().status(true).message("Vehicle brands deleted successfully").build();
    }

    @Override
    public ApiResponse<VehicleBrandResDto> getById(Long id) {
        VehicleBrandResDto retrievedVehicleBrand = this.vehicleBrandService.getById(id);
        return ApiResponse.<VehicleBrandResDto>builder().status(true).message("Vehicle brand retrieved successfully").data(retrievedVehicleBrand).build();
    }

    @Override
    public ApiResponse<List<VehicleBrandResDto>> getAll() {
        List<VehicleBrandResDto> retrievedVehicleBrands = this.vehicleBrandService.getAll();
        return ApiResponse.<List<VehicleBrandResDto>>builder().status(true).message("Vehicle brands retrieved successfully").data(retrievedVehicleBrands).build();
    }
}
