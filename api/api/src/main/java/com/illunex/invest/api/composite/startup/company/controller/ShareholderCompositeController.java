package com.illunex.invest.api.composite.startup.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.ShareholderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/company/shareholder")
public interface ShareholderCompositeController {
    @PostMapping(value = {"", "/"})
    ResponseEntity<ResponseData> editShareholders(ShareholderDTO shareholderDTO);
    @GetMapping(value = {"", "/"})
    ResponseEntity<ResponseData> getShareholders();
    @GetMapping(value = {"/{id}"})
    ResponseEntity<ResponseData> getShareholder(@PathVariable Long id);
    @DeleteMapping(value = "/{id}")
    ResponseEntity<ResponseData> deleteShareholder(@PathVariable Long id);
}
