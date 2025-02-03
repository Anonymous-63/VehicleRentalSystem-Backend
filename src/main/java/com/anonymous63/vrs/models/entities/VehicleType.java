package com.anonymous63.vrs.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "types")
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String vehicleClass;
    private String engineType;
    @Lob
    private String description;

    @ManyToOne
    private VehicleModel vehicleModel;
}
