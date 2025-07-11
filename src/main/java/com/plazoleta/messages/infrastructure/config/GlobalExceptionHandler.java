package com.plazoleta.messages.infrastructure.config;

import com.plazoleta.messages.domain.exceptions.SmsDeliveryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SmsDeliveryException.class)
    public ResponseEntity<String> handleSmsDeliveryException(SmsDeliveryException ex) {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Fallo en el envío del mensaje SMS: " + ex.getMessage());
    }

    // Puedes agregar otros manejadores genéricos si deseas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error inesperado: " + ex.getMessage());
    }
}

