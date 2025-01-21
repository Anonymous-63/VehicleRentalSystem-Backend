package com.anonymous63.vrs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private final String entity;
    private final String field;
    private final String message;

    public ResourceNotFoundException(String entity, String field, String message) {
        super(String.format("%s not found with %s : %s", entity, field, message));
        this.entity = entity;
        this.field = field;
        this.message = message;
    }
}
