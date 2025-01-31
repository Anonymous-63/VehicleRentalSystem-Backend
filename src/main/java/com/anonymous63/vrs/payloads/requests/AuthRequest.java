package com.anonymous63.vrs.payloads.requests;

import lombok.Builder;
import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
