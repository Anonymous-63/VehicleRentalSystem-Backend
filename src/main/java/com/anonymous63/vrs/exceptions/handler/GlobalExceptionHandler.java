package com.anonymous63.vrs.exceptions.handler;

import com.anonymous63.vrs.exceptions.DuplicateResourceException;
import com.anonymous63.vrs.exceptions.ResourceNotFoundException;
import com.anonymous63.vrs.payloads.ApiResponse;
import com.anonymous63.vrs.payloads.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ApiResponse<?> handleDuplicateResourceException(DuplicateResourceException ex) {
        return ApiResponse.builder().status(false).message(ex.getMessage()).build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ApiResponse.builder().status(false).message(ex.getMessage()).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<List<ErrorResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ErrorResponse> responseList = ex.getBindingResult().getFieldErrors().stream().map(error -> ErrorResponse.builder().field(error.getField()).message(error.getDefaultMessage()).build()).toList();
        return ApiResponse.<List<ErrorResponse>>builder().status(false).errors(responseList).build();
    }
}
