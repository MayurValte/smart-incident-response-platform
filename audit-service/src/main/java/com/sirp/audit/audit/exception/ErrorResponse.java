package com.sirp.audit.audit.exception;

import java.time.Instant;
import java.util.List;

public record ErrorResponse(

    Instant timestamp,

    Integer status,

    String error,

    String message,

    String path,

    List<String> details

) {

}