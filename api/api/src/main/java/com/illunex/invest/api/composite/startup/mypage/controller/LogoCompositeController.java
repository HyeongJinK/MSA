package com.illunex.invest.api.composite.startup.mypage.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.LogoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/myPage/company/logo")
public interface LogoCompositeController {
    @GetMapping
    ResponseEntity<ResponseData> getLogo();
    @PostMapping
    ResponseEntity<ResponseData> updateLogo(@RequestBody LogoDTO logoDTO);
}
