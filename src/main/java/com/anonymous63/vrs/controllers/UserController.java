package com.anonymous63.vrs.controllers;

import com.anonymous63.vrs.models.dtos.reqDtos.UserReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.UserResDto;
import com.anonymous63.vrs.payloads.ApiResponse;
import com.anonymous63.vrs.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController implements CrudController<UserReqDto, UserResDto, Long> {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ApiResponse<UserResDto> create(UserReqDto userReqDto) {
        UserResDto createdUser = this.userService.create(userReqDto);
        return ApiResponse.<UserResDto>builder().status(true).message("User created successfully.").data(createdUser).build();
    }

    @Override
    public ApiResponse<UserResDto> update(Long aLong, UserReqDto userReqDto) {
        return null;
    }

    @Override
    public ApiResponse<?> delete(Long aLong) {
        return null;
    }

    @Override
    public ApiResponse<UserResDto> getById(Long aLong) {
        return null;
    }

    @Override
    public ApiResponse<List<UserResDto>> getAll() {
        return null;
    }
}
