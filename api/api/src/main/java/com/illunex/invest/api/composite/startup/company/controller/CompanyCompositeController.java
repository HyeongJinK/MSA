package com.illunex.invest.api.composite.startup.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.CompanyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value = "/company")
public interface CompanyCompositeController {
    @GetMapping
    ResponseEntity<ResponseData> getCompanyInfo();
    @PostMapping
    ResponseEntity<ResponseData> editCompanyInfo(@RequestBody CompanyDTO companyDTO);
    @PostMapping("/logo")
    ResponseEntity<ResponseData> uploadLogo(@RequestParam("file") MultipartFile file);
    @GetMapping("/niceCompanyInfo")
    ResponseEntity<ResponseData> getNiceCompanyInfo(@RequestParam("businessNumber") String businessNumber);
}
