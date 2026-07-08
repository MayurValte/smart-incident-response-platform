package com.sirp.incident.exception;

import jakarta.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.List;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IncidentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleIncidentNotFound(IncidentNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(Instant.now(), 404, "Not Found", ex.getMessage(),
                                                   ErrorCode.INCIDENT_NOT_FOUND, null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidStatusTransitionException.class)
    public ResponseEntity<ErrorResponse> handleTransition(InvalidStatusTransitionException ex) {
        ErrorResponse response = new ErrorResponse(Instant.now(), 409, "Conflict", ex.getMessage(),
                                                   ErrorCode.INVALID_TRANSITION, null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validation(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
                                .toList();
        ErrorResponse response = new ErrorResponse(Instant.now(), 400, "Validation Error", "Request validation failed",
                                                   ErrorCode.VALIDATION_ERROR, errors);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> constraint(ConstraintViolationException ex) {
        ErrorResponse response = new ErrorResponse(Instant.now(), 400, "Validation Error", ex.getMessage(),
                                                   ErrorCode.VALIDATION_ERROR, null);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> illegal(IllegalArgumentException ex) {
        ErrorResponse response = new ErrorResponse(Instant.now(), 400, "Bad Request", ex.getMessage(),
                                                   ErrorCode.INVALID_STATUS, null);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(OptimisticLockingFailureException.class)
    public ResponseEntity<ErrorResponse> optimistic(OptimisticLockingFailureException ex) {
        ErrorResponse response = new ErrorResponse(Instant.now(), 409, "Conflict", "Concurrent modification detected",
                                                   ErrorCode.INVALID_TRANSITION, null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exception(Exception ex) {
        ErrorResponse response = new ErrorResponse(Instant.now(), 500, "Internal Server Error", ex.getMessage(),
                                                   ErrorCode.INTERNAL_SERVER_ERROR, null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}