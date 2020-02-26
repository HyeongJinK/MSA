package com.illunex.invest.user.controller;

import com.illunex.invest.api.core.user.controller.SignUpController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignUpControllerImpl implements SignUpController {
    //private final

    @Override
    public ResponseEntity<String> signUp(String username, String password) {
        return null;
    }
}
