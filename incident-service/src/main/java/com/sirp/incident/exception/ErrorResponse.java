package com.sirp.incident.exception;

import java.time.Instant;
import java.util.List;

public record ErrorResponse(

    Instant timestamp,

    Integer status,

    String error,

    String message,

    ErrorCode code,

    List<String> details

) {

}