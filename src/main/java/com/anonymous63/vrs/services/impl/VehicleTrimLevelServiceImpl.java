package com.anonymous63.vrs.services.impl;

import com.anonymous63.vrs.exceptions.DuplicateResourceException;
import com.anonymous63.vrs.exceptions.ResourceNotFoundException;
import com.anonymous63.vrs.models.dtos.reqDtos.VehicleTrimLevelReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleTrimLevelResDto;
import com.anonymous63.vrs.models.entities.VehicleTrimLevel;
import com.anonymous63.vrs.repositories.VehicleTrimLevelRepo;
import com.anonymous63.vrs.services.VehicleTrimLevelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleTrimLevelServiceImpl implements VehicleTrimLevelService {

    private final VehicleTrimLevelRepo vehicleTrimLevelRepo;
    private final ModelMapper mapper;

    public VehicleTrimLevelServiceImpl(VehicleTrimLevelRepo vehicleTrimLevelRepo, ModelMapper mapper) {
        this.vehicleTrimLevelRepo = vehicleTrimLevelRepo;
        this.mapper = mapper;
    }

    @Override
    public VehicleTrimLevelResDto create(VehicleTrimLevelReqDto request) {
        this.vehicleTrimLevelRepo.findByName(request.getName()).ifPresent(vehicleTrimLevel -> {
            throw new DuplicateResourceException(VehicleTrimLevel.class.getSimpleName(), request.getName());
        });
        VehicleTrimLevel trimLevel = mapper.map(request, VehicleTrimLevel.class);
        VehicleTrimLevel createdTrimLevel = this.vehicleTrimLevelRepo.save(trimLevel);
        return this.mapper.map(createdTrimLevel, VehicleTrimLevelResDto.class);
    }

    @Override
    public VehicleTrimLevelResDto getById(Long id) {
        VehicleTrimLevel trimLevel = this.vehicleTrimLevelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(VehicleTrimLevel.class.getSimpleName(), "id", String.valueOf(id)));
        return this.mapper.map(trimLevel, VehicleTrimLevelResDto.class);
    }

    @Override
    public List<VehicleTrimLevelResDto> getAll() {
        List<VehicleTrimLevel> trimLevels = this.vehicleTrimLevelRepo.findAll();
        List<VehicleTrimLevelResDto> vehicleTrimLevelResDtos = new ArrayList<>();
        trimLevels.forEach(trimLevel -> vehicleTrimLevelResDtos.add(this.mapper.map(trimLevel, VehicleTrimLevelResDto.class)));
        return vehicleTrimLevelResDtos;
    }

    @Override
    public VehicleTrimLevelResDto update(Long id, VehicleTrimLevelReqDto request) {
        VehicleTrimLevel trimLevel = this.vehicleTrimLevelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(VehicleTrimLevel.class.getSimpleName(), "id", String.valueOf(id)));
        this.vehicleTrimLevelRepo.findByName(request.getName()).ifPresent(existingVehicleTrimLevel -> {
            if (!existingVehicleTrimLevel.getId().equals(id)) {
                throw new DuplicateResourceException(VehicleTrimLevel.class.getSimpleName(), request.getName());
            }
        });
        this.mapper.map(request, trimLevel);
        VehicleTrimLevel updatedVehicleTrimLevel = this.vehicleTrimLevelRepo.save(trimLevel);
        return this.mapper.map(updatedVehicleTrimLevel, VehicleTrimLevelResDto.class);
    }

    @Override
    public void delete(Long id) {
        VehicleTrimLevel trimLevel = this.vehicleTrimLevelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(VehicleTrimLevel.class.getSimpleName(), "id", String.valueOf(id)));
        this.vehicleTrimLevelRepo.delete(trimLevel);
    }

    @Override
    public void multiDelete(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("The list of IDs cannot be null or empty.");
        }
        List<VehicleTrimLevel> trimLevels = this.vehicleTrimLevelRepo.findAllById(ids);
        this.vehicleTrimLevelRepo.deleteAll(trimLevels);
    }
}
