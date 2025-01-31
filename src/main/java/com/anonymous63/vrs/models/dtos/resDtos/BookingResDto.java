package com.anonymous63.vrs.models.dtos.resDtos;

import com.anonymous63.vrs.models.entities.User;
import com.anonymous63.vrs.models.entities.Vehicle;
import com.anonymous63.vrs.utils.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResDto {
    private Long bookingId;
    private UserResDto user;
    private VehicleResDto vehicle;
    @JsonFormat(pattern = Constant.DATETIME_FORMAT)
    private LocalDateTime startDateTime;
    @JsonFormat(pattern = Constant.DATETIME_FORMAT)
    private LocalDateTime endDateTime;
    private Double price;
    private Boolean status;
}
