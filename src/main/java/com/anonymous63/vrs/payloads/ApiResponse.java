package com.anonymous63.vrs.payloads;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private Boolean status;
    private String message;
    private T data;
    private List<ErrorResponse> errors;
}
