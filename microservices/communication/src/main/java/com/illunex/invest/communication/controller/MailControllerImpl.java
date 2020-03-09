package com.illunex.invest.communication.controller;

import com.illunex.invest.api.core.communication.controller.MailController;
import com.illunex.invest.api.core.communication.model.SignUpMailRequest;
import com.illunex.invest.communication.dto.SenderDto;
import com.illunex.invest.communication.model.SignUpMail;
import com.illunex.invest.communication.service.Sender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MailControllerImpl implements MailController {
    private final Sender sender;

    @Override
    public ResponseEntity<String> signUpCertification(SignUpMailRequest request) {
        List<String> to = new ArrayList<>();
        to.add(request.getUserName());
        sender.send(SenderDto.builder()
                .from(SignUpMail.from)
                .to(to)
                .subject("이펙트몰 회원으로 가입하셨습니다.")
                .content(SignUpMail.mail
                        .replace("{{userId}}", request.getUserName())
                        .replace("{{url}}", request.getUrl())
                )
                .build());
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
