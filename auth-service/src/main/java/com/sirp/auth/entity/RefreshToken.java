package com.sirp.auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "refresh_tokens",
        indexes = {
                @Index(
                        name = "idx_refresh_token",
                        columnList = "token"
                ),
                @Index(
                        name = "idx_refresh_user",
                        columnList = "user_id"
                )
        }
)
public class RefreshToken {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            unique = true,
            length = 512
    )
    private String token;
    @Column(
            nullable = false
    )
    private Long userId;
    @Column(
            nullable = false
    )
    private Instant expiryDate;
    @Column(
            nullable = false
    )
    private Boolean revoked;
}