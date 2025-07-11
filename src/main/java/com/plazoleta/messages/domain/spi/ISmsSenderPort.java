package com.plazoleta.messages.domain.spi;

public interface ISmsSenderPort {
    void sendSms(String toPhoneNumber, String messageText);
}
