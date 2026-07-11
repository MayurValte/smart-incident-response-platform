package com.sirp.workflow.dto.response;

import com.sirp.common.enums.IncidentSeverity;
import com.sirp.common.enums.WorkflowStatus;
import java.time.Instant;
import java.util.UUID;

public record WorkflowResponse(

    UUID id,

    UUID incidentId,

    UUID assignedTo,

    UUID assignedTeam,

    WorkflowStatus workflowStatus,

    IncidentSeverity priority,

    Integer escalationLevel,

    Instant slaDeadline,

    Instant nextEscalationTime,

    Instant resolvedAt,

    Instant closedAt,

    String remarks,

    Instant createdAt,

    Instant updatedAt

) {

}