package com.illunex.invest.mail.dto;

import com.amazonaws.services.simpleemail.model.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SenderDto {
    private String from;
    private List<String> to = new ArrayList<>();
    private String subject;
    private String content;
    private final String CONFIGSET = "ConfigSet";

    @Builder
    public SenderDto(String from, List<String> to, String subject, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public void addTo(String email){
        this.to.add(email);
    }

    public SendEmailRequest toSendRequestDto(){
        return new SendEmailRequest()
                .withDestination(getDestination())
                .withMessage(getMessage())
                .withSource(this.from)
                .withConfigurationSetName(CONFIGSET);
    }

    private Message getMessage() {
        return new Message()
                    .withSubject(createContent(this.subject))
                    .withBody(new Body()
                            .withHtml(createContent(this.content)));
    }

    private Destination getDestination() {
        return new Destination()
                    .withToAddresses(this.to);
    }

    private Content createContent(String text) {
        return new Content()
                .withCharset("UTF-8")
                .withData(text);
    }
}
