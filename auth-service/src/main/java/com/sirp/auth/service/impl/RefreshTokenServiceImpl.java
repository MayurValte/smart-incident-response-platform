package com.sirp.auth.service.impl;

import com.sirp.auth.entity.RefreshToken;
import com.sirp.auth.repository.RefreshTokenRepository;
import com.sirp.auth.security.JwtProperties;
import com.sirp.auth.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class RefreshTokenServiceImpl
        implements RefreshTokenService {
    private final RefreshTokenRepository repository;
    private final JwtProperties properties;

    @Override
    public RefreshToken createToken(
            Long userId
    ) {
        repository.deleteByUserId(
                userId
        );
        RefreshToken token =
                RefreshToken.builder()
                        .userId(
                                userId
                        )
                        .token(
                                UUID.randomUUID()
                                        .toString()
                        )
                        .expiryDate(
                                Instant.now()
                                        .plusMillis(
                                                properties
                                                        .getRefreshExpiration()
                                        )
                        )
                        .revoked(
                                false
                        )
                        .build();
        return repository.save(
                token
        );
    }

    @Override
    public RefreshToken validateToken(
            String token
    ) {
        RefreshToken refreshToken =
                repository.findByToken(
                                token
                        )
                        .orElseThrow(
                                () ->
                                        new RuntimeException(
                                                "Refresh token not found"
                                        )
                        );
        if (
                Boolean.TRUE.equals(
                        refreshToken.getRevoked()
                )
        ) {
            throw new RuntimeException(
                    "Refresh token revoked"
            );
        }
        if (
                refreshToken
                        .getExpiryDate()
                        .isBefore(
                                Instant.now()
                        )
        ) {
            repository.delete(
                    refreshToken
            );
            throw new RuntimeException(
                    "Refresh token expired"
            );
        }
        return refreshToken;
    }

    @Override
    public void deleteToken(
            Long userId
    ) {
        repository.deleteByUserId(
                userId
        );
    }
}