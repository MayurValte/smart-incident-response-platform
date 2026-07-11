package com.sirp.workflow.feign.dto;

import java.time.Instant;
import java.util.UUID;

public record CommentResponse(

    UUID id,

    String message,

    UUID createdBy,

    Instant createdAt

) {

}
