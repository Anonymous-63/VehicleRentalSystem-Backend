package com.anonymous63.vrs.payloads.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {
    private Boolean status;
    private String token;
    private String refreshToken;
}
