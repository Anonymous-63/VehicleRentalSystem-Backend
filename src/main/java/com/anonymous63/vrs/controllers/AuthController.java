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
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ApiResponse<UserResDto>> register(@RequestBody UserReqDto request) {
        UserResDto createdUser = this.userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<UserResDto>builder().status(true).message("Register successfully.").data(createdUser).build());
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> createToken(@RequestBody AuthRequest authRequest) {
        this.authenticate(authRequest.getEmail().toLowerCase(), authRequest.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authRequest.getEmail());

        String token = this.jwtHelper.generateToken(userDetails);
        String refreshToken = this.jwtHelper.generateRefreshToken(userDetails);

        AuthResponse jwtAuthResponse = AuthResponse.builder()
                .status(true)
                .token(token)
                .refreshToken(refreshToken)
                .build();

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

    private void authenticate(String email, String password) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(email, password);
            this.authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid email or password!");
        } catch (Exception e) {
            throw new RuntimeException("Authentication failed!");
        }
    }

}
