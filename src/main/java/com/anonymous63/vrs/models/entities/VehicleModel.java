package com.anonymous63.vrs.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "models")
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String description;

    @ManyToOne
    private VehicleBrand vehicleBrand;

    @OneToMany(mappedBy = "vehicleModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VehicleType> vehicleTypes = new ArrayList<>();
}
