package com.illunex.invest.api.composite.startup.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.CompanyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/company")
public interface CompanyCompositeController {
    @GetMapping
    ResponseEntity<ResponseData> getCompanyInfo();
    @PostMapping
    ResponseEntity<ResponseData> editCompanyInfo(CompanyDTO companyDTO);
}
