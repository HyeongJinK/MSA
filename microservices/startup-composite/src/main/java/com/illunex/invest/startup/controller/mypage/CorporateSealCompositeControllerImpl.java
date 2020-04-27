package com.illunex.invest.startup.controller.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.mypage.controller.CorporateSealCompositeController;
import com.illunex.invest.startup.service.mypage.CorporateSealIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class CorporateSealCompositeControllerImpl implements CorporateSealCompositeController {
    private final CorporateSealIntegrationService corporateSealIntegrationService;

    @Override
    public ResponseEntity<ResponseList> signature() {
        return corporateSealIntegrationService.signatureList();
    }

    @Override
    public ResponseEntity<ResponseData> signature(MultipartFile file) {
        return corporateSealIntegrationService.signature(file);
    }

    @Override
    public ResponseEntity<ResponseData> toggleSignature(Long id) {
        return corporateSealIntegrationService.signatureStatusToggle(id);
    }

    @Override
    public ResponseEntity<ResponseData> delSignature(Long id) {
        return corporateSealIntegrationService.signatureDelete(id);
    }
}
