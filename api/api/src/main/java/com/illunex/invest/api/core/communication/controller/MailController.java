package com.illunex.invest.api.core.communication.controller;

import com.illunex.invest.api.core.communication.model.SignUpMailRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mail")
public interface MailController {
    @PostMapping("/signUp")
    ResponseEntity<String> signUpCertification(@RequestBody SignUpMailRequest request);
}
