package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.InvestSettingDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "투자 설정")
@RequestMapping("/investSetting")
public interface InvestSettingController {
    @GetMapping
    ResponseEntity<InvestSettingDTO> getInvestSetting(@RequestParam("companyIdx") Long companyIdx);
    @PostMapping
    ResponseEntity<ResponseData> saveInvestSetting(@RequestBody InvestSettingDTO investSettingDTO);
}
