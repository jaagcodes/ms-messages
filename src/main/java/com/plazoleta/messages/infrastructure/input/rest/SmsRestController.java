package com.plazoleta.messages.infrastructure.input.rest;

import com.plazoleta.messages.application.dto.SendSmsRequest;
import com.plazoleta.messages.application.handler.ISmsHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SmsRestController {

    private static final Logger logger = LoggerFactory.getLogger(SmsRestController.class);
    private final ISmsHandler smsHandler;

    @PostMapping("/send-sms")
    public ResponseEntity<String> sendSms(@RequestBody @Valid SendSmsRequest request) {
        logger.info("[SmsRestController] Received sms request: {}", request.toString());
        smsHandler.sendSms(request);
        return ResponseEntity.status(HttpStatus.OK).body("Mensaje enviado correctamente");
    }
}
