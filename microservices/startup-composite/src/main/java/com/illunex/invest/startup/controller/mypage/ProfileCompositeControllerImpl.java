package com.illunex.invest.startup.controller.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.mypage.controller.ProfileCompositeController;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.startup.service.mypage.ProfileIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileCompositeControllerImpl implements ProfileCompositeController {
    private final ProfileIntegrationService profileIntegrationService;

    @Override
    public ResponseEntity<ResponseData> getProfile() {
        return profileIntegrationService.getProfile();
    }

    @Override
    public ResponseEntity<ResponseData> editProfile(UserDTO userDTO) {
        return profileIntegrationService.editProfiwle(userDTO);
    }
}
