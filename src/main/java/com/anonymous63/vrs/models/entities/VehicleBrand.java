package com.anonymous63.vrs.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "brands")
public class VehicleBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String logo;
    private String description;

    @OneToMany(mappedBy = "vehicleBrand", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VehicleModel> vehicleModels = new ArrayList<>();
}
