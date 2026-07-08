package com.sirp.common.events;

import java.time.Instant;
import java.util.UUID;

public record IncidentAssignedEvent(

    UUID eventId,

    UUID incidentId,

    UUID assignedTo,

    UUID assignedBy,

    Instant occurredAt

) {

}