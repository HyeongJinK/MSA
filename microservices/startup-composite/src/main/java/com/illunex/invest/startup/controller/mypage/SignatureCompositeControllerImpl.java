package com.illunex.invest.startup.controller.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.mypage.controller.SignatureCompositeController;
import com.illunex.invest.startup.controller.StartupDefaultController;
import com.illunex.invest.startup.service.mypage.SignatureIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class SignatureCompositeControllerImpl extends StartupDefaultController implements SignatureCompositeController {
    private final SignatureIntegrationService signatureIntegrationService;

    @Override
    public ResponseEntity<ResponseList> signature() {
        return signatureIntegrationService.signatureList();
    }

    @Override
    public ResponseEntity<ResponseList> signatureActive() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData> signature(MultipartFile file) {
        return signatureIntegrationService.signature(file);
    }

    @Override
    public ResponseEntity<ResponseData> toggleSignature(Long id) {
        return signatureIntegrationService.signatureStatusToggle(id);
    }

    @Override
    public ResponseEntity<ResponseData> delSignature(Long id) {
        return signatureIntegrationService.signatureDelete(id);
    }
}
