package com.anonymous63.vrs.services.impl;

import com.anonymous63.vrs.exceptions.DuplicateResourceException;
import com.anonymous63.vrs.exceptions.ResourceNotFoundException;
import com.anonymous63.vrs.models.dtos.reqDtos.VehicleTypeReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleTrimLevelResDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleTypeResDto;
import com.anonymous63.vrs.models.entities.VehicleTrimLevel;
import com.anonymous63.vrs.models.entities.VehicleType;
import com.anonymous63.vrs.repositories.VehicleTypeRepo;
import com.anonymous63.vrs.services.VehicleTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

    private final VehicleTypeRepo vehicleTypeRepo;
    private final ModelMapper mapper;

    public VehicleTypeServiceImpl(VehicleTypeRepo vehicleTypeRepo, ModelMapper mapper) {
        this.vehicleTypeRepo = vehicleTypeRepo;
        this.mapper = mapper;
    }

    @Override
    public VehicleTypeResDto create(VehicleTypeReqDto request) {
        this.vehicleTypeRepo.findByType(request.getType()).ifPresent(vehicleType -> {
            throw new DuplicateResourceException(VehicleType.class.getSimpleName(), request.getType());
        });
        VehicleType type = mapper.map(request, VehicleType.class);
        VehicleType createdType = this.vehicleTypeRepo.save(type);
        return this.mapper.map(createdType, VehicleTypeResDto.class);
    }

    @Override
    public VehicleTypeResDto getById(Long id) {
        VehicleType type = this.vehicleTypeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(VehicleType.class.getSimpleName(), "id", String.valueOf(id)));
        return this.mapper.map(type, VehicleTypeResDto.class);
    }

    @Override
    public List<VehicleTypeResDto> getAll() {
        List<VehicleType> types = this.vehicleTypeRepo.findAll();
        List<VehicleTypeResDto> vehicleTypesDtos = new ArrayList<>();
        types.forEach(type -> vehicleTypesDtos.add(this.mapper.map(type, VehicleTypeResDto.class)));
        return vehicleTypesDtos;
    }

    @Override
    public VehicleTypeResDto update(Long id, VehicleTypeReqDto request) {
        VehicleType type = this.vehicleTypeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(VehicleType.class.getSimpleName(), "id", String.valueOf(id)));
        this.vehicleTypeRepo.findByType(request.getType()).ifPresent(existingVehicleType -> {
            if (!existingVehicleType.getId().equals(id)) {
                throw new DuplicateResourceException(VehicleType.class.getSimpleName(), request.getType());
            }
        });
        this.mapper.map(request, type);
        VehicleType updatedVehicleType = this.vehicleTypeRepo.save(type);
        return this.mapper.map(updatedVehicleType, VehicleTypeResDto.class);
    }

    @Override
    public void delete(Long id) {
        VehicleType type = this.vehicleTypeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(VehicleType.class.getSimpleName(), "id", String.valueOf(id)));
        this.vehicleTypeRepo.delete(type);
    }

    @Override
    public void multiDelete(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("The list of IDs cannot be null or empty.");
        }
        List<VehicleType> types = this.vehicleTypeRepo.findAllById(ids);
        this.vehicleTypeRepo.deleteAll(types);
    }
}
