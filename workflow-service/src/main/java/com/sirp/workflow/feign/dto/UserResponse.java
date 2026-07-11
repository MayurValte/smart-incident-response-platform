package com.sirp.workflow.feign.dto;

import java.util.UUID;

public record UserResponse(
    UUID id,
    String username,
    String email,
    String password,
    String role,
    Boolean enabled
) {

}