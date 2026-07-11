package com.sirp.workflow.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ResolveWorkflowRequest(

    @NotBlank(message = "Resolution remarks are required")
    String remarks

) {

}