package com.illunex.invest.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.user.controller.CertificationController;
import com.illunex.invest.user.service.CertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CertificationControllerImpl extends UserDefaultController implements CertificationController {
    private final CertificationService certificationService;

    @Override
    public ResponseEntity<ResponseData> certification(String token) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message(certificationService.certification(token))
                .build());
    }
}
