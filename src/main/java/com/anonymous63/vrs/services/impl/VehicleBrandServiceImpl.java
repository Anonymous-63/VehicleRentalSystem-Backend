package com.anonymous63.vrs.services.impl;

import com.anonymous63.vrs.exceptions.DuplicateResourceException;
import com.anonymous63.vrs.exceptions.ResourceNotFoundException;
import com.anonymous63.vrs.models.dtos.reqDtos.VehicleBrandReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleBrandResDto;
import com.anonymous63.vrs.models.entities.VehicleBrand;
import com.anonymous63.vrs.repositories.VehicleBrandRepo;
import com.anonymous63.vrs.services.VehicleBrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleBrandServiceImpl implements VehicleBrandService {

    private final VehicleBrandRepo vehicleBrandRepo;
    private final ModelMapper mapper;

    public VehicleBrandServiceImpl(VehicleBrandRepo vehicleBrandRepo, ModelMapper mapper) {
        this.vehicleBrandRepo = vehicleBrandRepo;
        this.mapper = mapper;
    }

    @Override
    public VehicleBrandResDto create(VehicleBrandReqDto request) {
        this.vehicleBrandRepo.findByBrand(request.getBrand()).ifPresent(vehicleBrand -> {
            throw new DuplicateResourceException(VehicleBrand.class.getSimpleName(), request.getBrand());
        });
        VehicleBrand brand = mapper.map(request, VehicleBrand.class);
        VehicleBrand createdBrand = vehicleBrandRepo.save(brand);
        return this.mapper.map(createdBrand, VehicleBrandResDto.class);
    }

    @Override
    public VehicleBrandResDto getById(Long id) {
        VehicleBrand brand = this.vehicleBrandRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(VehicleBrand.class.getSimpleName(), "id", String.valueOf(id)));
        return this.mapper.map(brand, VehicleBrandResDto.class);
    }

    @Override
    public List<VehicleBrandResDto> getAll() {
        List<VehicleBrand> brands = this.vehicleBrandRepo.findAll();
        List<VehicleBrandResDto> vehicleBrandResDtos = new ArrayList<>();
        brands.forEach(brand -> vehicleBrandResDtos.add(this.mapper.map(brand, VehicleBrandResDto.class)));
        return vehicleBrandResDtos;
    }

    @Override
    public VehicleBrandResDto update(Long id, VehicleBrandReqDto request) {
        VehicleBrand brand = this.vehicleBrandRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(VehicleBrand.class.getSimpleName(), "id", String.valueOf(id)));
        this.vehicleBrandRepo.findByBrand(request.getBrand()).ifPresent(existingVehicleBrand -> {
            if (!existingVehicleBrand.getId().equals(id)) {
                throw new DuplicateResourceException(VehicleBrand.class.getSimpleName(), request.getBrand());
            }
        });
        this.mapper.map(request, brand);
        VehicleBrand updatedVehicleBrand = this.vehicleBrandRepo.save(brand);
        return this.mapper.map(updatedVehicleBrand, VehicleBrandResDto.class);
    }

    @Override
    public void delete(Long id) {
        VehicleBrand brand = this.vehicleBrandRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(VehicleBrand.class.getSimpleName(), "id", String.valueOf(id)));
        this.vehicleBrandRepo.delete(brand);
    }

    @Override
    public void multiDelete(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("The list of IDs cannot be null or empty.");
        }
        List<VehicleBrand> brands = this.vehicleBrandRepo.findAllById(ids);
        this.vehicleBrandRepo.deleteAll(brands);
    }
}
