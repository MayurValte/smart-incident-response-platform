package com.sirp.incident.exception;

public class InvalidStatusTransitionException extends RuntimeException {

    public InvalidStatusTransitionException(String current, String target) {
        super("Invalid transition from " + current + " to " + target);
    }
}