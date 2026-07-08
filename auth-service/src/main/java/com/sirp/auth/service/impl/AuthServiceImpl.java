package com.sirp.auth.service.impl;

import com.sirp.auth.dto.request.LoginRequest;
import com.sirp.auth.dto.request.RefreshTokenRequest;
import com.sirp.auth.dto.response.AuthResponse;
import com.sirp.auth.dto.response.UserSecurityResponse;
import com.sirp.auth.entity.RefreshToken;
import com.sirp.auth.feign.UserClient;
import com.sirp.auth.security.JwtProperties;
import com.sirp.auth.security.JwtService;
import com.sirp.auth.service.AuthService;
import com.sirp.auth.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserClient userClient;
    private final JwtService jwtService;
    private final JwtProperties jwtProperties;
    private final RefreshTokenService refreshTokenService;

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        UserSecurityResponse user = userClient.findByEmail(
                request.email()
        );
        String accessToken = jwtService.generateToken(
                user.id(),
                user.email(),
                user.role()
        );
        RefreshToken refreshToken =
                refreshTokenService.createToken(
                        user.id()
                );
        return new AuthResponse(
                accessToken,
                refreshToken.getToken(),
                "Bearer",
                jwtProperties.getExpiration()
        );
    }

    @Override
    public AuthResponse refresh(
            RefreshTokenRequest request
    ) {
        RefreshToken token =
                refreshTokenService.validateToken(
                        request.refreshToken()
                );
        UserSecurityResponse user =
                userClient.findById(
                        token.getUserId()
                );
        String accessToken =
                jwtService.generateToken(
                        user.id(),
                        user.email(),
                        user.role()
                );
        RefreshToken newRefreshToken =
                refreshTokenService.createToken(
                        user.id()
                );
        return new AuthResponse(
                accessToken,
                newRefreshToken.getToken(),
                "Bearer",
                jwtProperties.getExpiration()
        );
    }

    @Override
    public void logout(Long userId) {
        refreshTokenService.deleteToken(
                userId
        );
    }
}