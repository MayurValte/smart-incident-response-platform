package com.sirp.auth.advice;

import com.sirp.auth.dto.response.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(
            Exception.class
    )
    public ResponseEntity<ApiErrorResponse>
    handle(
            Exception ex,
            HttpServletRequest request
    ) {
        ApiErrorResponse response =
                new ApiErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Internal Server Error",
                        ex.getMessage(),
                        request.getRequestURI()
                );
        return ResponseEntity
                .status(
                        HttpStatus.INTERNAL_SERVER_ERROR
                )
                .body(
                        response
                );
    }

    @ExceptionHandler(
            MethodArgumentNotValidException.class
    )
    public ResponseEntity<ApiErrorResponse>
    validation(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ) {
        ApiErrorResponse response =
                new ApiErrorResponse(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        "Validation Error",
                        ex.getBindingResult()
                                .getFieldError()
                                .getDefaultMessage(),
                        request.getRequestURI()
                );
        return ResponseEntity
                .badRequest()
                .body(
                        response
                );
    }
}