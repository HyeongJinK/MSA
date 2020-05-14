package com.illunex.invest.startup.controller.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.mypage.controller.LogoCompositeController;
import com.illunex.invest.api.core.company.dto.LogoDTO;
import com.illunex.invest.startup.service.mypage.LogoIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LogoCompositeControllerImpl implements LogoCompositeController {
    private final LogoIntegrationService logoIntegrationService;

    @Override
    public ResponseEntity<ResponseData> getLogo() {
        return logoIntegrationService.getLogo();
    }

    @Override
    public ResponseEntity<ResponseData> updateLogo(LogoDTO logoDTO) {
        return logoIntegrationService.updateLogo(logoDTO);
    }
}
