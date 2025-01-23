package com.anonymous63.vrs.services.impl;

import com.anonymous63.vrs.exceptions.DuplicateResourceException;
import com.anonymous63.vrs.models.dtos.reqDtos.UserReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.UserResDto;
import com.anonymous63.vrs.models.entities.User;
import com.anonymous63.vrs.repositories.UserRepo;
import com.anonymous63.vrs.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
            if (!user.getId().equals(request.getId())) {
                String conflictField = "";
                if (user.getName().equals(request.getName())) {
                    conflictField = "name: " + request.getName();
                }
                if (user.getEmail().equals(request.getEmail())) {
                    if (!conflictField.isEmpty()) {
                        conflictField += " and ";
                    }
                    conflictField += "email: " + request.getEmail();
                }
                throw new DuplicateResourceException(User.class.getSimpleName(), conflictField);
            }
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
