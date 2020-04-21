package com.illunex.invest.company.controller;

import com.illunex.invest.api.core.company.controller.BusinessController;
import com.illunex.invest.api.core.company.dto.BusinessDTO;
import com.illunex.invest.company.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BusinessControllerImpl implements BusinessController {
    private final BusinessService businessService;
    @Override
    public ResponseEntity<BusinessDTO> getBusiness(Long companyId) {
        return ResponseEntity.ok(businessService.getBusiness(companyId));
    }

    @Override
    public ResponseEntity<BusinessDTO> editBusiness(BusinessDTO businessDTO) {
        return ResponseEntity.ok(businessService.editBusiness(businessDTO));
    }
}
