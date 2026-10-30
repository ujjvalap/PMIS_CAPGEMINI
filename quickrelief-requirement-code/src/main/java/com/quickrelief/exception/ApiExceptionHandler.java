
package com.quickrelief.exception;

import com.quickrelief.dto.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ApiExceptionHandler {

    private static final Logger log =
            LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<ApiError> handleInsufficientStock(
            InsufficientStockException exception) {

        return build(HttpStatus.CONFLICT, exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(
            MethodArgumentNotValidException exception) {

        String message = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(error -> error.getField() + ": "
                        + error.getDefaultMessage())
                .orElse("Request validation failed");

        return build(HttpStatus.BAD_REQUEST, message);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleInvalidJson(
            HttpMessageNotReadableException exception) {

        log.warn("Invalid request JSON: {}", exception.getMessage());

        return build(
                HttpStatus.BAD_REQUEST,
                "Request body is missing or invalid"
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleUnexpected(
            Exception exception) {

        // Log the complete exception in the server console.
        log.error("Unexpected API error occurred", exception);

        // Never expose internal exception details to API clients.
        return build(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred"
        );
    }

    private ResponseEntity<ApiError> build(
            HttpStatus status,
            String message) {

        return ResponseEntity.status(status).body(
                new ApiError(
                        Instant.now(),
                        status.value(),
                        status.getReasonPhrase(),
                        message
                )
        );
    }
}
