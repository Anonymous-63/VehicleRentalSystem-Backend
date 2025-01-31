package com.anonymous63.vrs.models.dtos.reqDtos;

import com.anonymous63.vrs.models.entities.User;
import com.anonymous63.vrs.models.entities.Vehicle;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class BookingReqDto {
    private User user;
    private Vehicle vehicle;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Double price;
    private Boolean status;
}
