package com.plazoleta.messages.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendSmsRequest {

    @NotBlank(message = "Phone number is required")
    private String to;

    @NotBlank(message = "Message content is required")
    private String message;

    @Override
    public String toString() {
        return "SendSmsRequest{" +
                "to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
