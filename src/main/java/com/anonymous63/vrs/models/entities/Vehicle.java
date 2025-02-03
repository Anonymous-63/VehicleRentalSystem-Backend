package com.anonymous63.vrs.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    @Column(unique = true, nullable = false)
    private String licensePlate;
    private int manufactureYear;
    private String vehicleRegStatus;
    private String fuelType;
    private String transmission;
    @ManyToOne
    private VehicleBrand brand;
    @ManyToOne
    private VehicleType type;
    @ManyToOne
    private VehicleModel model;
}
