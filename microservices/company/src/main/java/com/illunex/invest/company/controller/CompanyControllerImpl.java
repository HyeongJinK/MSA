package com.illunex.invest.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.company.controller.CompanyController;
import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.LogoDTO;
import com.illunex.invest.api.core.company.request.CompanyRegisterRequest;
import com.illunex.invest.company.exception.NoneCompanyException;
import com.illunex.invest.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Log
@RestController
@RequiredArgsConstructor
public class CompanyControllerImpl implements CompanyController {

    private final CompanyService companyService;

    @Override
    public ResponseEntity<ResponseList> getAllList() {

        return ResponseEntity.ok(ResponseList.builder()
                .errorCode(0)
                .message("success")
                .data(Collections.singletonList(companyService.getAllList()))
                .build());
    }

    @Override
    public ResponseEntity<CompanyDTO> getCompany(Long id) {
        //log.info(id.toString());
        CompanyDTO companyDTO = companyService.getCompanyById(id);
        //log.info(companyDTO.toString());
        return ResponseEntity.ok(companyDTO);
    }

    @Override
    public ResponseEntity<ResponseData> updateCompany(CompanyDTO companyDTO) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(companyService.updateCompany(companyDTO))
                .build());
    }

    @Override
    public ResponseEntity<LogoDTO> getLogo(Long companyIdx) {
        return ResponseEntity.ok(companyService.getLogo(companyIdx));
    }

    @Override
    public ResponseEntity<ResponseData> updateLogo(LogoDTO logoDTO) {
        companyService.updateLogo(logoDTO.getCompanyIdx(), logoDTO.getSquareLogo(), logoDTO.getRectangleLogo());
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> registerCompany(CompanyRegisterRequest request) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(companyService.registerCompany(request.getBusinessNumber()))
                .build());
    }

    @ExceptionHandler(NoneCompanyException.class)
    public ResponseEntity<CompanyDTO> NoneCompanyException(NoneCompanyException e) {
        return ResponseEntity.status(500).body(null);
    }
}
