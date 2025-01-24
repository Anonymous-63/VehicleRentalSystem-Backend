package com.anonymous63.vrs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException(String entity, String message) {
        super(String.format("%s already exists with %s", entity, message));
    }
}
