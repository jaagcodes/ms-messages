package com.plazoleta.messages.domain.api;

public interface ISmsServicePort {
    void sendSms(String phoneNumber, String message);
}
