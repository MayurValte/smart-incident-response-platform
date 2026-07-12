package com.sirp.notification.exception;

import com.sirp.common.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotificationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotificationNotFoundException ex,
        HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(Instant.now(), HttpStatus.NOT_FOUND.value(),
                                                   HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(),
                                                   request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex,
        HttpServletRequest request) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
                                .toList();
        ErrorResponse response = new ErrorResponse(Instant.now(), HttpStatus.BAD_REQUEST.value(),
                                                   HttpStatus.BAD_REQUEST.getReasonPhrase(), "Validation failed",
                                                   request.getRequestURI(), null, errors);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest request) {
        log.error("Unhandled exception", ex);
        ErrorResponse response = new ErrorResponse(Instant.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                   HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                                                   ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
