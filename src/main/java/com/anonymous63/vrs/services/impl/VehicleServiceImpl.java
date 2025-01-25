package com.anonymous63.vrs.services.impl;

import com.anonymous63.vrs.exceptions.DuplicateResourceException;
import com.anonymous63.vrs.exceptions.ResourceNotFoundException;
import com.anonymous63.vrs.models.dtos.reqDtos.VehicleReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.VehicleResDto;
import com.anonymous63.vrs.models.entities.Vehicle;
import com.anonymous63.vrs.repositories.VehicleRepo;
import com.anonymous63.vrs.services.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepo vehicleRepo;
    private final ModelMapper mapper;

    public VehicleServiceImpl(VehicleRepo vehicleRepo, ModelMapper mapper) {
        this.vehicleRepo = vehicleRepo;
        this.mapper = mapper;
    }

    @Override
    public VehicleResDto create(VehicleReqDto request) {
        Vehicle vehicle = this.mapper.map(request, Vehicle.class);
        Vehicle createdVehicle = this.vehicleRepo.save(vehicle);
        return this.mapper.map(createdVehicle, VehicleResDto.class);
    }

    @Override
    public VehicleResDto getById(Long id) {
        Vehicle vehicle = this.vehicleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Vehicle.class.getSimpleName(), "id", String.valueOf(id)));
        return this.mapper.map(vehicle, VehicleResDto.class);
    }

    @Override
    public List<VehicleResDto> getAll() {
        List<Vehicle> vehicles = this.vehicleRepo.findAll();
        List<VehicleResDto> vehicleResDtos = new ArrayList<>();
        vehicles.forEach(vehicle -> vehicleResDtos.add(this.mapper.map(vehicle, VehicleResDto.class)));
        return vehicleResDtos;
    }

    @Override
    public VehicleResDto update(Long id, VehicleReqDto request) {
        Vehicle vehicle = this.vehicleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Vehicle.class.getSimpleName(), "id", String.valueOf(id)));
        if (!vehicle.getId().equals(id)) {
            throw new DuplicateResourceException(Vehicle.class.getSimpleName(), String.valueOf(request.getId()));
        }
        this.mapper.map(request, vehicle);
        Vehicle updatedVehicle = this.vehicleRepo.save(vehicle);
        return this.mapper.map(updatedVehicle, VehicleResDto.class);
    }

    @Override
    public void delete(Long id) {
        Vehicle vehicle = this.vehicleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Vehicle.class.getSimpleName(), "id", String.valueOf(id)));
        this.vehicleRepo.delete(vehicle);
    }

    @Override
    public void multiDelete(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("The list of IDs cannot be null or empty.");
        }
        List<Vehicle> vehicles = this.vehicleRepo.findAllById(ids);
        this.vehicleRepo.deleteAll(vehicles);
    }
}
