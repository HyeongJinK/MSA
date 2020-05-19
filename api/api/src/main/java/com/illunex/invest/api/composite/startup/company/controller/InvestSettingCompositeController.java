package com.illunex.invest.api.composite.startup.company.controller;


import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.InvestSettingDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/investSetting")
public interface InvestSettingCompositeController {
    @GetMapping
    ResponseEntity<ResponseData> getInvestSetting();
    @PostMapping
    ResponseEntity<ResponseData> editInvestSetting(@RequestBody InvestSettingDTO investSettingDTO);
}
