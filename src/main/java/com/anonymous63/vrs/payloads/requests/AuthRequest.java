package com.anonymous63.vrs.payloads.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthRequest {
    private String username;
    private String password;
}
