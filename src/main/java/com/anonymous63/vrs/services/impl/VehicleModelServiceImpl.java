package com.anonymous63.vrs.services.impl;

import com.anonymous63.vrs.exceptions.DuplicateResourceException;
import com.anonymous63.vrs.exceptions.ResourceNotFoundException;
import com.anonymous63.vrs.models.dtos.reqDtos.VehicleModelReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleModelResDto;
import com.anonymous63.vrs.models.entities.VehicleBrand;
import com.anonymous63.vrs.models.entities.VehicleModel;
import com.anonymous63.vrs.repositories.VehicleBrandRepo;
import com.anonymous63.vrs.repositories.VehicleModelRepo;
import com.anonymous63.vrs.services.VehicleModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {

    private final VehicleModelRepo vehicleModelRepo;
    private final VehicleBrandRepo vehicleBrandRepo;
    private final ModelMapper mapper;

    public VehicleModelServiceImpl(VehicleModelRepo vehicleModelRepo, VehicleBrandRepo vehicleBrandRepo, ModelMapper mapper) {
        this.vehicleModelRepo = vehicleModelRepo;
        this.vehicleBrandRepo = vehicleBrandRepo;
        this.mapper = mapper;
    }

    @Override
    public VehicleModelResDto create(VehicleModelReqDto request) {
        this.vehicleModelRepo.findByModel(request.getModel()).ifPresent(vehicleModel -> {
            throw new DuplicateResourceException(VehicleModel.class.getSimpleName(), request.getModel());
        });

        VehicleBrand brand = this.vehicleBrandRepo.findById(request.getBrandId())
                .orElseThrow(() -> new ResourceNotFoundException(VehicleBrand.class.getSimpleName(), "Brand", String.valueOf(request.getBrandId())));

        VehicleModel model = mapper.map(request, VehicleModel.class);
        model.setVehicleBrand(brand);
        VehicleModel createdModel = this.vehicleModelRepo.save(model);
        return this.mapper.map(createdModel, VehicleModelResDto.class);
    }

    @Override
    public VehicleModelResDto getById(Long id) {
        VehicleModel model = this.vehicleModelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(VehicleModel.class.getSimpleName(), "id", String.valueOf(id)));
        return this.mapper.map(model, VehicleModelResDto.class);
    }

    @Override
    public List<VehicleModelResDto> getAll() {
        List<VehicleModel> models = this.vehicleModelRepo.findAll();
        List<VehicleModelResDto> vehicleModelResDtos = new ArrayList<>();
        models.forEach(model -> vehicleModelResDtos.add(this.mapper.map(model, VehicleModelResDto.class)));
        return vehicleModelResDtos;
    }

    @Override
    public VehicleModelResDto update(Long id, VehicleModelReqDto request) {
        VehicleModel model = this.vehicleModelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(VehicleModel.class.getSimpleName(), "id", String.valueOf(id)));
        this.vehicleModelRepo.findByModel(request.getModel()).ifPresent(existingVehicleModel -> {
            if (!existingVehicleModel.getId().equals(id)) {
                throw new DuplicateResourceException(VehicleModel.class.getSimpleName(), request.getModel());
            }
        });
        this.mapper.map(request, model);
        VehicleModel updatedVehicleModel = this.vehicleModelRepo.save(model);
        return this.mapper.map(updatedVehicleModel, VehicleModelResDto.class);
    }

    @Override
    public void delete(Long id) {
        VehicleModel model = this.vehicleModelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(VehicleModel.class.getSimpleName(), "id", String.valueOf(id)));
        this.vehicleModelRepo.delete(model);
    }

    @Override
    public void multiDelete(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("The list of IDs cannot be null or empty.");
        }
        List<VehicleModel> models = this.vehicleModelRepo.findAllById(ids);
        this.vehicleModelRepo.deleteAll(models);
    }
}
