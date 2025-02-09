package com.anonymous63.vrs.configs;

import com.anonymous63.vrs.models.entities.User;
import com.anonymous63.vrs.repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner intiUser() {
        return args -> {
            if (userRepo.count() == 0) {
                User user = new User();
                user.setName("admin");
                user.setEmail("admin@gmail.com");
                user.setPassword(passwordEncoder.encode("admin@123"));
                user.setMobileNo("0000000000");
                user.setRole("admin");
                user.setEnabled(true);
                userRepo.save(user);
                System.out.println("Admin user created successfully!");
            } else {
                userRepo.findByEmail("admin@gmail.com").ifPresentOrElse(
                        existingUser -> System.out.println("Admin user already exists: " + existingUser.getEmail()),
                        () -> {
                            User user = new User();
                            user.setName("admin");
                            user.setEmail("admin@gmail.com");
                            user.setPassword(passwordEncoder.encode("admin@123"));
                            user.setMobileNo("0000000000");
                            user.setRole("admin");
                            user.setEnabled(true);
                            userRepo.save(user);
                            System.out.println("Admin user was missing and has been created.");
                        }
                );
            }
        };
    }
}
