package com.sirp.auth.dto.response;

public record UserSecurityResponse(
        Long id,
        String username,
        String email,
        String password,
        String role,
        Boolean enabled
) {
}