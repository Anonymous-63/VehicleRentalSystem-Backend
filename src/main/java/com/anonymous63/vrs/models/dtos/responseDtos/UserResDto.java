package com.anonymous63.vrs.models.dtos.responseDtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
public class UserResDto {
    private Long id;
    private String name;
    private String email;
    private String about;
}
