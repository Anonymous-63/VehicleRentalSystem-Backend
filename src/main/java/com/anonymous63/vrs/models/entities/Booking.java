package com.anonymous63.vrs.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    @ManyToOne
    private User user;
    @ManyToOne
    private Vehicle vehicle;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    private Double price;
    private Boolean status;
}
