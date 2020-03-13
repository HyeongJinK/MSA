package com.illunex.invest.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.user.controller.ChangePasswordController;
import com.illunex.invest.api.core.user.model.ChangePasswordRequest;
import com.illunex.invest.user.service.ChangePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChangePasswordControllerImpl extends UserDefaultController implements ChangePasswordController {
    private final ChangePasswordService changePasswordService;

    @Override
    public ResponseEntity<ResponseData> changePassword(ChangePasswordRequest request) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message(changePasswordService.changePassword(request.getUsername()
                        , request.getPrePassword()
                        , request.getPassword()))
                .build());
    }
}
