package com.sirp.common.events;

import java.time.Instant;
import java.util.UUID;

public record IncidentResolvedEvent(

    UUID eventId,

    UUID incidentId,

    UUID resolvedBy,

    Instant occurredAt

) {

}