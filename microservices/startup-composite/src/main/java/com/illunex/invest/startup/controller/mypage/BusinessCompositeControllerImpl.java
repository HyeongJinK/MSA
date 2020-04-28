package com.illunex.invest.startup.controller.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.mypage.controller.BusinessCompositeController;
import com.illunex.invest.api.core.company.dto.BusinessDTO;
import com.illunex.invest.startup.service.mypage.BusinessIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class BusinessCompositeControllerImpl implements BusinessCompositeController {
    private final BusinessIntegrationService businessIntegrationService;

    @Override
    public ResponseEntity<ResponseData> getBusiness() {
        return businessIntegrationService.getBusiness();
    }

    @Override
    public ResponseEntity<ResponseData> editBusiness(BusinessDTO businessDTO) {
        return businessIntegrationService.editBusiness(businessDTO);
    }

    @Override
    public ResponseEntity<ResponseData> uploadFile(MultipartFile file) {
        return ResponseEntity.ok(ResponseData.builder()
                .build());
    }
}
