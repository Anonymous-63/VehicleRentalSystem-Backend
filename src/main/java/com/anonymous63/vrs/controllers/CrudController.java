package com.anonymous63.vrs.controllers;

import com.anonymous63.vrs.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CrudController<REQ, RES, ID> {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ApiResponse<RES> create(@RequestBody REQ req);

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    ApiResponse<RES> update(@PathVariable ID id, @RequestBody REQ req);

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<?> delete(@PathVariable ID id);

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<RES> getById(@PathVariable ID id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<List<RES>> getAll();
}
