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
    public ApiResponse<UserResDto> update(Long id, UserReqDto userReqDto) {
        UserResDto updatedUser = this.userService.update(id, userReqDto);
        return ApiResponse.<UserResDto>builder().status(true).message("User updated successfully").data(updatedUser).build();
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        this.userService.delete(id);
        return ApiResponse.builder().status(true).message("User deleted successfully.").build();
    }

    @Override
    public ApiResponse<?> multiDelete(List<Long> ids) {
        this.userService.multiDelete(ids);
        return ApiResponse.builder().status(true).message("Users deleted successfully").build();
    }

    @Override
    public ApiResponse<UserResDto> getById(Long id) {
        UserResDto userResDto = this.userService.getById(id);
        return ApiResponse.<UserResDto>builder().status(true).message("User fetched successfully").data(userResDto).build();
    }

    @Override
    public ApiResponse<List<UserResDto>> getAll() {
        List<UserResDto> userResDtos = this.userService.getAll();
        return ApiResponse.<List<UserResDto>>builder().status(true).message("Users fetched successfully").data(userResDtos).build();
    }
}
