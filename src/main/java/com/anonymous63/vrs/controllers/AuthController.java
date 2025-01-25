package com.anonymous63.vrs.controllers;

import com.anonymous63.vrs.models.dtos.reqDtos.UserReqDto;
import com.anonymous63.vrs.models.dtos.resDtos.UserResDto;
import com.anonymous63.vrs.payloads.requests.AuthRequest;
import com.anonymous63.vrs.payloads.responses.ApiResponse;
import com.anonymous63.vrs.payloads.responses.AuthResponse;
import com.anonymous63.vrs.services.UserService;
import com.anonymous63.vrs.utils.JwtHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtHelper jwtHelper;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthController(JwtHelper jwtHelper, UserDetailsService userDetailsService, AuthenticationManager authenticationManager, UserService userService) {
        this.jwtHelper = jwtHelper;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResDto> register(@RequestBody UserReqDto request){
        UserResDto createdUser = this.userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> createToken(@RequestBody AuthRequest authRequest) {
        this.authenticate(authRequest.getUsername(), authRequest.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authRequest.getUsername());

        String token = this.jwtHelper.generateToken(userDetails);
        String refreshToken = this.jwtHelper.generateRefreshToken(userDetails);

        AuthResponse jwtAuthResponse = AuthResponse.builder()
                .token(token)
                .refreshToken(refreshToken)
                .build();

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

    private void authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        this.authenticationManager.authenticate(authenticationToken);
    }
}
