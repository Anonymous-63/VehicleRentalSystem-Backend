package com.anonymous63.vrs.exceptions.handler;

import com.anonymous63.vrs.exceptions.DuplicateResourceException;
import com.anonymous63.vrs.exceptions.ResourceNotFoundException;
import com.anonymous63.vrs.payloads.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
