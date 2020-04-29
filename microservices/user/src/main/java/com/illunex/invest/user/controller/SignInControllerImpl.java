package com.illunex.invest.user.controller;

import com.illunex.invest.api.core.user.controller.SingInController;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.request.SignInRequest;
import com.illunex.invest.user.service.SignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignInControllerImpl extends UserDefaultController implements SingInController {
    private final SignInService signInService;

    @Override
    public ResponseEntity<UserDTO> findUser(SignInRequest request) {
        return ResponseEntity.ok(signInService.findByUsername(request.getUsername()));
    }
}
