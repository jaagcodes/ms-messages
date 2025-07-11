package com.plazoleta.messages.domain.exceptions;

public class SmsDeliveryException extends RuntimeException{

    public SmsDeliveryException(Exception e){
        super("Error enviando el SMS: " + e.getMessage());
    }

    public SmsDeliveryException(String message, Throwable cause) {
        super(message, cause);
    }

    public SmsDeliveryException(Throwable cause) {
        super("Error al enviar el SMS", cause);
    }
}
