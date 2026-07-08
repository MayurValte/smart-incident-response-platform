package com.sirp.incident.incident.dto.response;

import com.sirp.incident.incident.enums.IncidentStatus;

import java.time.Instant;
import java.util.UUID;

public record HistoryResponse(

        UUID id,

        IncidentStatus oldStatus,

        IncidentStatus newStatus,

        UUID changedBy,

        Instant changedAt

) {
}