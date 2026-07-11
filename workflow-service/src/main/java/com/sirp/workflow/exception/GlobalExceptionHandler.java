package com.sirp.workflow.exception;

import jakarta.validation.ConstraintViolationException;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WorkflowNotFoundException.class)
    public ProblemDetail handleWorkflowNotFound(WorkflowNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                                                                 ex.getMessage());
        problem.setTitle("Workflow Not Found");
        return problem;
    }

    @ExceptionHandler(WorkflowAlreadyExistsException.class)
    public ProblemDetail handleWorkflowAlreadyExists(WorkflowAlreadyExistsException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT,
                                                                 ex.getMessage());
        problem.setTitle("Workflow Already Exists");
        return problem;
    }

    @ExceptionHandler(InvalidWorkflowStateException.class)
    public ProblemDetail handleInvalidWorkflowState(InvalidWorkflowStateException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                                                                 ex.getMessage());
        problem.setTitle("Invalid Workflow State");
        return problem;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream().map(
            FieldError::getDefaultMessage).collect(Collectors.joining(", "));
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, message);
        problem.setTitle("Validation Failed");
        return problem;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ProblemDetail handleConstraintViolation(ConstraintViolationException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                                                                 ex.getMessage());
        problem.setTitle("Constraint Violation");
        return problem;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
                                                                 ex.getMessage());
        problem.setTitle("Internal Server Error");
        return problem;
    }
}