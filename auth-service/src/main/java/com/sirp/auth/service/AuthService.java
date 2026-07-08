package com.sirp.auth.service;

import com.sirp.auth.dto.request.LoginRequest;
import com.sirp.auth.dto.request.RefreshTokenRequest;
import com.sirp.auth.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse login(
            LoginRequest request
    );

    AuthResponse refresh(
            RefreshTokenRequest request
    );

    void logout(
            Long userId
    );
}