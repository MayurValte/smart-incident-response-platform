package com.sirp.incident.exception;

public class IncidentAlreadyClosedException extends RuntimeException {

    public IncidentAlreadyClosedException() {
        super("Incident already closed");
    }
}