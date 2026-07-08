package com.sirp.incident.incident.dto.request;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record AssignIncidentRequest(

    @NotNull
    UUID assignedTo

) {

}