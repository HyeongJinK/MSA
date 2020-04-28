package com.illunex.invest.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.user.controller.SignatureController;
import com.illunex.invest.api.core.user.dto.SignatureDTO;
import com.illunex.invest.api.core.user.enumable.SignatureStatus;
import com.illunex.invest.api.core.user.request.SignatureRequest;
import com.illunex.invest.user.service.SignatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignatureControllerImpl extends UserDefaultController implements SignatureController {
    private final SignatureService signatureService;

    @Override
    public ResponseEntity<ResponseList> signatureList(Long userId) {
        ResponseList<SignatureDTO> data = new ResponseList(0
                , "Success"
                , signatureService.signatureList(userId));
        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<ResponseList> signatureListActive(Long userId) {
        ResponseList<SignatureDTO> data = new ResponseList<>(0
                , "success"
                , signatureService.signatureList(userId, SignatureStatus.Active));
        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<ResponseData> addSignature(SignatureRequest request) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .data(signatureService.addSignature(request))
                .message("Success")
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> toggleSignature(Long id) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .data(signatureService.toggleSignature(id))
                .message("Success")
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> deleteSignature(Long id) {
        signatureService.deleteSignature(id);
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("Success")
                .build());
    }
}
