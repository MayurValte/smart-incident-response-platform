package com.sirp.common.events;

import com.sirp.common.enums.IncidentPriority;
import com.sirp.common.enums.IncidentSeverity;
import java.time.Instant;
import java.util.UUID;

public record IncidentClosedEvent(

    UUID eventId,

    UUID incidentId,

    String incidentNumber,

    String title,

    IncidentPriority priority,

    IncidentSeverity severity,

    UUID closedBy,

    Instant occurredAt

) {

}