package com.sirp.auth.service;

import com.sirp.auth.entity.RefreshToken;

public interface RefreshTokenService {
    RefreshToken createToken(
            Long userId
    );

    RefreshToken validateToken(
            String token
    );

    void deleteToken(
            Long userId
    );
}