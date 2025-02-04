package com.anonymous63.vrs.models.dtos.reqDtos;

import com.anonymous63.vrs.models.entities.User;
import com.anonymous63.vrs.models.entities.Vehicle;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class BookingReqDto {
    private Long userId;
    private Long vehicleId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Double price;
}
