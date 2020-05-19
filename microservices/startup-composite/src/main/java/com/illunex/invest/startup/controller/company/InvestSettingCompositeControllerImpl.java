package com.illunex.invest.startup.controller.company;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.company.controller.InvestSettingCompositeController;
import com.illunex.invest.api.core.company.dto.InvestSettingDTO;
import com.illunex.invest.startup.service.company.InvestSettingCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InvestSettingCompositeControllerImpl implements InvestSettingCompositeController {
    private final InvestSettingCompositeIntegration investSettingCompositeIntegration;

    @Override
    public ResponseEntity<ResponseData> getInvestSetting() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData> editInvestSetting(InvestSettingDTO investSettingDTO) {
        return null;
    }
}
