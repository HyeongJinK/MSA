package com.illunex.invest.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.company.controller.CompanyController;
import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.request.CompanyRegisterRequest;
import com.illunex.invest.company.exception.NoneCompanyException;
import com.illunex.invest.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequiredArgsConstructor
public class CompanyControllerImpl implements CompanyController {
    private Log log = LogFactory.getLog(CompanyControllerImpl.class);

    private final CompanyService companyService;

    @Override
    public ResponseEntity<ResponseList> getAllList() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData> getCompany(Long id) {
        log.debug(id);

        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(companyService.getCompanyById(id))
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> updateCompany(CompanyDTO companyDTO) {
        return null;
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
    public ResponseEntity<ResponseData> NoneCompanyException(NoneCompanyException e) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(100)
                .message("회사가 없습니다.")
                .data(e.getMessage())
                .build());
    }
}
