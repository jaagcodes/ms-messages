package com.plazoleta.messages.application.handler;

import com.plazoleta.messages.application.dto.SendSmsRequest;
import com.plazoleta.messages.domain.api.ISmsServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsHandler implements ISmsHandler{

    private  final ISmsServicePort sendSmsServicePort;

    @Override
    public void sendSms(SendSmsRequest sendSmsRequest) {
        sendSmsServicePort.sendSms(sendSmsRequest.getTo(), sendSmsRequest.getMessage());
    }
}
