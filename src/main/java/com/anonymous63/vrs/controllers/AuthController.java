package com.anonymous63.vrs.controllers;

import com.anonymous63.vrs.services.UserService;
import com.anonymous63.vrs.utils.JwtHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;

public class AuthController {

    private final JwtHelper jwtHelper;
    private final UserDetailsService userDetailsService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public AuthController(JwtHelper jwtHelper, UserDetailsService userDetailsService, UserService userService, AuthenticationManager authenticationManager) {
        this.jwtHelper = jwtHelper;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }
}
