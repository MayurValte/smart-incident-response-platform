package com.sirp.workflow.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CloseWorkflowRequest(

    @NotBlank(message = "Closing remarks are required")
    String remarks

) {

}