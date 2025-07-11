package com.plazoleta.messages.domain.model;

public class SmsMessage {
    private String to;
    private String body;

    public SmsMessage(String to, String body) {
        this.to = to;
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "SmsMessage{" +
                "to='" + to + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
