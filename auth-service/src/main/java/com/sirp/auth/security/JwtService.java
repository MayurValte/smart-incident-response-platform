package com.sirp.auth.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtProperties properties;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(
                properties
                        .getSecret()
                        .getBytes(
                                StandardCharsets.UTF_8
                        )
        );
    }

    public String generateToken(
            Long userId,
            String email,
            String role
    ) {
        Map<String, Object> claims =
                new HashMap<>();
        claims.put(
                "userId",
                userId
        );
        claims.put(
                "role",
                role
        );
        return buildToken(
                claims,
                email,
                properties.getExpiration()
        );
    }

    private String buildToken(
            Map<String, Object> claims,
            String subject,
            Long expiration
    ) {
        return Jwts.builder()
                .claims(
                        claims
                )
                .subject(
                        subject
                )
                .issuedAt(
                        new Date()
                )
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        +
                                        expiration
                        )
                )
                .signWith(
                        getSigningKey()
                )
                .compact();
    }

    public String extractUsername(
            String token
    ) {
        return extractClaims(
                token
        )
                .getSubject();
    }

    public Long extractUserId(
            String token
    ) {
        return extractClaims(
                token
        )
                .get(
                        "userId",
                        Long.class
                );
    }

    public String extractRole(
            String token
    ) {
        return extractClaims(
                token
        )
                .get(
                        "role",
                        String.class
                );
    }

    public Date extractExpiration(
            String token
    ) {
        return extractClaims(
                token
        )
                .getExpiration();
    }

    public boolean isExpired(
            String token
    ) {
        return extractExpiration(
                token
        )
                .before(
                        new Date()
                );
    }

    public boolean validate(
            String token,
            UserDetails user
    ) {
        String username =
                extractUsername(
                        token
                );
        return username.equals(
                user.getUsername()
        )
                &&
                !isExpired(
                        token
                );
    }

    private Claims extractClaims(
            String token
    ) {
        return Jwts.parser()
                .verifyWith(
                        getSigningKey()
                )
                .build()
                .parseSignedClaims(
                        token
                )
                .getPayload();
    }
}