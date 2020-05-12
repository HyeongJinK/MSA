package com.illunex.invest.communication.controller.mail;

import com.illunex.invest.api.core.communication.controller.MailController;
import com.illunex.invest.api.core.communication.model.SignUpMailRequest;
import com.illunex.invest.communication.dto.mail.SenderDto;
import com.illunex.invest.communication.model.mail.InviteMail;
import com.illunex.invest.communication.model.mail.SignUpMail;
import com.illunex.invest.communication.service.mail.Sender;
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

    @Override
    public ResponseEntity<String> invite(SignUpMailRequest request) {
        List<String> to = new ArrayList<>();
        to.add(request.getUserName());
        sender.send(SenderDto.builder()
                .from(InviteMail.from)
                .to(to)
                .subject("이펙트몰 회원으로 초하셨습니다.")
                .content(InviteMail.mail
                        .replace("{{userId}}", request.getUserName())
                        .replace("{{url}}", request.getUrl())
                )
                .build());
        return new ResponseEntity<>("success", HttpStatus.OK);
    }


}
