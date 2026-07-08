package com.sirp.incident.incident.dto.response;

import java.time.Instant;
import java.util.UUID;

public record AssignmentResponse(

        UUID assignedTo,

        UUID assignedBy,

        Instant assignedAt

) {
}