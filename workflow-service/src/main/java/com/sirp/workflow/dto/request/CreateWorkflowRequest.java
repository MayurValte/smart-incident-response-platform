package com.sirp.workflow.dto.request;

import com.sirp.common.enums.IncidentSeverity;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

public record CreateWorkflowRequest(

    @NotNull(message = "Incident Id is required")
    UUID incidentId,

    UUID assignedTo,

    UUID assignedTeam,

    @NotNull(message = "Priority is required")
    IncidentSeverity priority,

    @NotNull(message = "SLA deadline is required")
    @Future(message = "SLA deadline must be in future")
    Instant slaDeadline,

    Instant nextEscalationTime,

    String remarks

) {

}