package com.sirp.incident.integration.user.dto;

import java.util.Set;
import java.util.UUID;

public record UserResponse(

        UUID id,

        String username,

        String email,

        Boolean active,

        UUID teamId,

        Set<String> roles

) {
}