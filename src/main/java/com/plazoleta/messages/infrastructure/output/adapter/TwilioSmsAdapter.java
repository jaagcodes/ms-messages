package com.plazoleta.messages.infrastructure.output.adapter;

import com.plazoleta.messages.domain.spi.ISmsSenderPort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TwilioSmsAdapter implements ISmsSenderPort {

    private static final Logger logger = LoggerFactory.getLogger(TwilioSmsAdapter.class);

    @Value("${twilio.account-sid}")
    private String twilioAccountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.from-number}")
    private String fromNumber;

    @PostConstruct
    public void init() {
        Twilio.init(twilioAccountSid, authToken);
    }

    @Override
    public void sendSms(String toPhoneNumber, String messageText) {
        logger.info("[TwilioSmsAdapter] Creating and sending message from phone {} to phone number {} with message {}", fromNumber, toPhoneNumber, messageText);
        Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(fromNumber),
                messageText
        ).create();
    }
}
