package com.anonymous63.vrs.models.dtos.resDtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResDto {
    private Long id;
    private String name;
    private String email;
    private String mobileNo;
    private String role;
}
