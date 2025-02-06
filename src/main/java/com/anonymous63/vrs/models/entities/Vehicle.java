package com.anonymous63.vrs.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private VehicleBrand brand;
    @ManyToOne
    private VehicleType type;
    @ManyToOne
    private VehicleModel model;
    @Lob
    private String vehicleImg;
    private String color;
    @Column(unique = true, nullable = false)
    private String licensePlate;
    private int manufactureYear;
    private String vehicleRegStatus;
    private String fuelType;
    private String transmission;
    private Double pricePerDay;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();

}
