package com.anonymous63.vrs.services.impl;

import com.anonymous63.vrs.exceptions.DuplicateResourceException;
import com.anonymous63.vrs.models.dtos.requestDtos.UserReqDto;
import com.anonymous63.vrs.models.dtos.responseDtos.UserResDto;
import com.anonymous63.vrs.models.entities.User;
import com.anonymous63.vrs.repositories.UserRepo;
import com.anonymous63.vrs.services.UserService;
import org.modelmapper.ModelMapper;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public UserResDto create(UserReqDto request) {
        this.userRepo.findFirstByNameOrEmail(request.getName(), request.getEmail()).ifPresent(user -> {
            throw new DuplicateResourceException(User.class.getSimpleName(), request.getName());
        });
        User user = this.mapper.map(request, User.class);
        User createdUser = this.userRepo.save(user);
        return this.mapper.map(createdUser, UserResDto.class);
    }

    @Override
    public UserResDto getById(Long aLong) {
        return null;
    }

    @Override
    public List<UserResDto> getAll() {
        return List.of();
    }

    @Override
    public UserResDto update(Long aLong, UserReqDto request) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
