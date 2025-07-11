package com.plazoleta.messages.application.handler;

import com.plazoleta.messages.application.dto.SendSmsRequest;

public interface ISmsHandler {
    void sendSms(SendSmsRequest sendSmsRequest);
}
