package com.sirp.common.events;

import java.time.Instant;
import java.util.UUID;

public record IncidentClosedEvent(

    UUID eventId,

    UUID incidentId,

    UUID closedBy,

    Instant occurredAt

) {

}