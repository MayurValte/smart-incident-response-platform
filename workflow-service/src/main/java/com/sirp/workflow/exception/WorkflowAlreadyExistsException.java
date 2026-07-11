package com.sirp.workflow.exception;

public class WorkflowAlreadyExistsException extends RuntimeException {

    public WorkflowAlreadyExistsException(String message) {
        super(message);
    }

}