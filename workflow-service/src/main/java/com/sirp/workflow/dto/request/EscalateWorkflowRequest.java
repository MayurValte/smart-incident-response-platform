package com.sirp.workflow.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;

public record EscalateWorkflowRequest(

    @NotNull(message = "Next escalation time is required")
    @Future(message = "Next escalation time must be in future")
    Instant nextEscalationTime,

    String remarks

) {

}