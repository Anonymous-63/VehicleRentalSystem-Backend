package com.anonymous63.vrs.controllers;

import com.anonymous63.vrs.payloads.requests.AuthRequest;
import com.anonymous63.vrs.payloads.responses.AuthResponse;
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

    public AuthController(JwtHelper jwtHelper, UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
        this.jwtHelper = jwtHelper;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> crateToken(@RequestBody AuthRequest authRequest) {
        this.authenticate(authRequest.getUsername(), authRequest.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = this.jwtHelper.generateToken(userDetails);
        return ResponseEntity.status(HttpStatus.OK).body(AuthResponse.builder().token(token).build());
    }

    private void authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        this.authenticationManager.authenticate(authenticationToken);
    }
}
