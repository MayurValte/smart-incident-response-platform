package com.sirp.incident.incident.dto.response;

import java.time.Instant;
import java.util.UUID;

public record CommentResponse(

        UUID id,

        String message,

        UUID createdBy,

        Instant createdAt

) {
}