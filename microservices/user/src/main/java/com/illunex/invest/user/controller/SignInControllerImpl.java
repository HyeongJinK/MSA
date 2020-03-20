package com.illunex.invest.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.user.controller.SingInController;
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
    public ResponseEntity<ResponseData> findUser(SignInRequest request) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .data(signInService.findByUsername(request.getUsername()))
                .build());
    }
}
