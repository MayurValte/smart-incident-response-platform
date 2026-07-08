package com.sirp.common.events;

import java.time.Instant;
import java.util.UUID;

public record IncidentCreatedEvent(

    UUID eventId,

    UUID incidentId,

    String incidentNumber,

    String title,

    String severity,

    String priority,

    UUID createdBy,

    Instant occurredAt

) {

}