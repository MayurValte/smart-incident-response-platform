package com.sirp.workflow.feign.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record AssignIncidentRequest(

    @NotNull
    UUID assignedTo

) {

}