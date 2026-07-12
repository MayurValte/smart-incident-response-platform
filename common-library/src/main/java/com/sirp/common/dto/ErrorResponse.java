package com.sirp.common.dto;

import java.time.Instant;
import java.util.List;

/**
 * Single error response shape for every service in the platform. code is
 * an optional machine-readable identifier (e.g. an ErrorCode enum name)
 * for clients that want to branch on error type instead of parsing the
 * message string; leave it null if the service has no such vocabulary.
 */
public record ErrorResponse(

        Instant timestamp,

        int status,

        String error,

        String message,

        String path,

        String code,

        List<String> details

) {

    public ErrorResponse(Instant timestamp, int status, String error, String message, String path) {
        this(timestamp, status, error, message, path, null, List.of());
    }
}
