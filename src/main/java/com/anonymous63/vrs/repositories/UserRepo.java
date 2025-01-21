package com.anonymous63.vrs.repositories;

import com.anonymous63.vrs.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findFirstByNameOrEmail(String name, String email);
}
