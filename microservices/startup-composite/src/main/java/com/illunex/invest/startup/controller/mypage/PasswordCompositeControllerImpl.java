package com.illunex.invest.startup.controller.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.mypage.controller.PasswordCompositeController;
import com.illunex.invest.api.composite.startup.mypage.request.MyPageChangePasswordRequest;
import com.illunex.invest.startup.controller.StartupDefaultController;
import com.illunex.invest.startup.service.mypage.PasswordIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PasswordCompositeControllerImpl extends StartupDefaultController implements PasswordCompositeController {
    private final PasswordIntegrationService passwordIntegrationService;

    @Override
    public ResponseEntity<ResponseData> changePassword(MyPageChangePasswordRequest request) {
        return passwordIntegrationService.changePassword(request.getPrePassword(), request.getPassword());
    }
}
