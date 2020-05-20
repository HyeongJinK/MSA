package com.illunex.invest.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.controller.InvestSettingController;
import com.illunex.invest.api.core.company.dto.InvestSettingDTO;
import com.illunex.invest.company.service.InvestSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InvestSettingControllerImpl implements InvestSettingController {
    private final InvestSettingService investSettingService;

    @Override
    public ResponseEntity<InvestSettingDTO> getInvestSetting(Long companyIdx) {
        return ResponseEntity.ok(investSettingService.findByInvestSetting(companyIdx));
    }

    @Override
    public ResponseEntity<ResponseData> saveInvestSetting(InvestSettingDTO investSettingDTO) {
        investSettingService.save(investSettingDTO);
        return ResponseEntity.ok(ResponseData.builder().errorCode(0).message("success").build());
    }
}
