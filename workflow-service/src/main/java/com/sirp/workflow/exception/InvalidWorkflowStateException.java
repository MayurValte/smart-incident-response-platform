package com.sirp.workflow.exception;

public class InvalidWorkflowStateException extends RuntimeException {

    public InvalidWorkflowStateException(String message) {
        super(message);
    }

}