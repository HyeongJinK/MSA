package com.illunex.invest.startup.controller.company;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.company.controller.CompanyCompositeController;
import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.startup.controller.StartupDefaultController;
import com.illunex.invest.startup.service.company.CompanyCompositeIntegration;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Log
@RestController
@RequiredArgsConstructor
public class CompanyCompositeControllerImpl extends StartupDefaultController implements CompanyCompositeController {
    private final CompanyCompositeIntegration companyCompositeIntegration;

    @Override
    public ResponseEntity<ResponseData> getCompanyInfo() {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(companyCompositeIntegration.getCompanyInfo())
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> editCompanyInfo(CompanyDTO companyDTO) {
        log.info(companyDTO.toString());
        companyCompositeIntegration.editCompany(companyDTO);
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> uploadLogo(MultipartFile file) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(companyCompositeIntegration.uploadLogo(file))
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> getNiceCompanyInfo(String businessNumber) {
        return ResponseEntity.ok(ResponseData.builder()
                .data(companyCompositeIntegration.getNiceCompanyInfo(businessNumber))
                .errorCode(0)
                .message("success")
                .build());
    }
}
