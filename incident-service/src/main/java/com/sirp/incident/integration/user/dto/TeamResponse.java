package com.sirp.incident.integration.user.dto;

import java.util.UUID;

public record TeamResponse(

        UUID id,

        String name,

        Boolean active

) {
}