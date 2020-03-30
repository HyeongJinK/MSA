package com.illunex.invest.startup.controller.company;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.company.controller.CompanyCompositeController;
import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.startup.controller.StartupDefaultController;
import com.illunex.invest.startup.service.company.CompanyCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .build());
    }
}
