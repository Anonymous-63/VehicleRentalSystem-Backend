package com.anonymous63.vrs.services.impl;

import com.anonymous63.vrs.exceptions.DuplicateResourceException;
import com.anonymous63.vrs.exceptions.ResourceNotFoundException;
import com.anonymous63.vrs.models.dtos.reqDtos.UserReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.UserResDto;
import com.anonymous63.vrs.models.entities.User;
import com.anonymous63.vrs.repositories.UserRepo;
import com.anonymous63.vrs.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public UserResDto getById(Long id) {
        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), "id", String.valueOf(id)));
        return this.mapper.map(user, UserResDto.class);
    }

    @Override
    public List<UserResDto> getAll() {
        List<User> users = this.userRepo.findAll();
        List<UserResDto> userResDtos = new ArrayList<>();
        users.forEach(user -> userResDtos.add(this.mapper.map(user, UserResDto.class)));
        return userResDtos;
    }

    @Override
    public UserResDto update(Long id, UserReqDto request) {
        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), "id", String.valueOf(id)));
        this.userRepo.findFirstByNameOrEmail(request.getName(), request.getEmail()).ifPresent(existingUser -> {
            if (!existingUser.getId().equals(id)) {  // Ensure we're not conflicting with the current user
                String conflictField = "";
                if (existingUser.getName().equals(request.getName())) {
                    conflictField = "name: " + request.getName();
                }
                if (existingUser.getEmail().equals(request.getEmail())) {
                    if (!conflictField.isEmpty()) {
                        conflictField += " and ";
                    }
                    conflictField += "email: " + request.getEmail();
                }
                throw new DuplicateResourceException(User.class.getSimpleName(), conflictField);
            }
        });

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setAbout(request.getAbout());
        User updatedUser = this.userRepo.save(user);
        return this.mapper.map(updatedUser, UserResDto.class);
    }

    @Override
    public void delete(Long id) {
        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(User.class.getSimpleName(), "id", String.valueOf(id)));
        this.userRepo.delete(user);
    }

    @Override
    public void multiDelete(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("The list of IDs cannot be null or empty.");
        }
        List<User> users = this.userRepo.findAllById(ids);
        this.userRepo.deleteAll(users);
    }
}
