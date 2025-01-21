package com.anonymous63.vrs.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    private String licensePlate;
    private int manufYear;
    private String vehicleRegStatus;
    private String fuelType;
    private String transmission;

    @ManyToOne
    private User user;
}
