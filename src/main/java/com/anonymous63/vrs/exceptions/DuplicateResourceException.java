package com.anonymous63.vrs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateResourceException extends RuntimeException {
    private final String entity;
    private final String message;

    public DuplicateResourceException(String entity, String message) {
        super(String.format("%s already exists with : %s", entity, message));
        this.entity = entity;
        this.message = message;
    }
}
