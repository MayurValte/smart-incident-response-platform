package com.sirp.incident.incident.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ResolveIncidentRequest(

    @NotBlank
    String resolutionSummary

) {

}