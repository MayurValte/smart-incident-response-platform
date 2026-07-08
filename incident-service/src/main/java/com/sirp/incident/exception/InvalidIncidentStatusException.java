package com.sirp.incident.exception;

public class InvalidIncidentStatusException extends RuntimeException {

    public InvalidIncidentStatusException(String value) {
        super("Invalid incident status : " + value);
    }
}