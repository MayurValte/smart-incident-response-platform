package com.sirp.auth.controller;

import com.sirp.auth.dto.request.LoginRequest;
import com.sirp.auth.dto.request.RefreshTokenRequest;
import com.sirp.auth.dto.response.AuthResponse;
import com.sirp.auth.security.UserPrincipal;
import com.sirp.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(
        "/api/v1/auth"
)
public class AuthController {
    private final AuthService authService;

    @PostMapping(
            "/login"
    )
    public ResponseEntity<AuthResponse>
    login(
            @Valid
            @RequestBody
            LoginRequest request
    ) {
        return ResponseEntity.ok(
                authService.login(
                        request
                )
        );
    }

    @PostMapping(
            "/refresh"
    )
    public ResponseEntity<AuthResponse>
    refresh(
            @Valid
            @RequestBody
            RefreshTokenRequest request
    ) {
        return ResponseEntity.ok(
                authService.refresh(
                        request
                )
        );
    }

    @PostMapping(
            "/logout"
    )
    public ResponseEntity<Void>
    logout(
            Authentication authentication
    ) {
        UserPrincipal principal =
                (
                        UserPrincipal
                        )
                        authentication
                                .getPrincipal();
        authService.logout(
                principal
                        .getUser()
                        .id()
        );
        return ResponseEntity.ok()
                .build();
    }
}