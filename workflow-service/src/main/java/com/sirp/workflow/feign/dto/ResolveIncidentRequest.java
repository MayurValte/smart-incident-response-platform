package com.sirp.workflow.feign.dto;

import jakarta.validation.constraints.NotBlank;

public record ResolveIncidentRequest(

    @NotBlank
    String resolutionSummary

) {

}
