package com.illunex.invest.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.user.controller.SignatureController;
import com.illunex.invest.user.service.SignatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class SignatureControllerImpl extends UserDefaultController implements SignatureController {
    private final SignatureService signatureService;

    @Override
    public ResponseEntity<ResponseData> changePassword(Long userId, MultipartFile file, String fileName) {
        signatureService.addSignature(file, userId);
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .data("success")
                .build());
    }
}
