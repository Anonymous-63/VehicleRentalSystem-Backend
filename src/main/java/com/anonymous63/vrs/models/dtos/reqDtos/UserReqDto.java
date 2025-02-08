package com.anonymous63.vrs.models.dtos.reqDtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserReqDto {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    private String mobileNo;
    private String role;
    private Boolean enabled;
}
