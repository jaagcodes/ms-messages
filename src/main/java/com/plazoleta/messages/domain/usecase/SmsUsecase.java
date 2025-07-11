package com.plazoleta.messages.domain.usecase;

import com.plazoleta.messages.domain.api.ISmsServicePort;
import com.plazoleta.messages.domain.exceptions.SmsDeliveryException;
import com.plazoleta.messages.domain.spi.ISmsSenderPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsUsecase implements ISmsServicePort {

    private final ISmsSenderPort smsSenderPort;
    private static final Logger logger = LoggerFactory.getLogger(SmsUsecase.class);

    public SmsUsecase(ISmsSenderPort smsSenderPort) {
        this.smsSenderPort = smsSenderPort;
    }

    @Override
    public void sendSms(String phoneNumber, String message) {
        try{
            logger.info("[UseCase] Sending sms to phone number {} with message {}", phoneNumber, message);
            smsSenderPort.sendSms(phoneNumber, message);
        } catch (Exception e){
            throw new SmsDeliveryException(e);
        }

    }
}
