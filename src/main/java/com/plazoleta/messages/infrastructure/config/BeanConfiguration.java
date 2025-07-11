package com.plazoleta.messages.infrastructure.config;

import com.plazoleta.messages.domain.api.ISmsServicePort;
import com.plazoleta.messages.domain.spi.ISmsSenderPort;
import com.plazoleta.messages.domain.usecase.SmsUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ISmsServicePort sendSmsServicePort(ISmsSenderPort smsSenderPort) {
        return new SmsUsecase(smsSenderPort);
    }
}
