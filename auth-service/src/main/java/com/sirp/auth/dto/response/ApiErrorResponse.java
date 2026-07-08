package com.sirp.auth.dto.response;

import java.time.LocalDateTime;

public record ApiErrorResponse(
        LocalDateTime timestamp,
        Integer status,
        String error,
        String message,
        String path
) {
}