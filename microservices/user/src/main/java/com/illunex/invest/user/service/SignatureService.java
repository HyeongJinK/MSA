package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.SignatureDTO;
import com.illunex.invest.api.core.user.enumable.SignatureStatus;
import com.illunex.invest.api.core.user.request.SignatureRequest;

import java.util.List;

public interface SignatureService {
    List<SignatureDTO> signatureList(Long userId);
    List<SignatureDTO> signatureList(Long userId, SignatureStatus status);
    SignatureDTO addSignature(SignatureRequest request);
    String toggleSignature(Long id);
    void deleteSignature(Long id);
}
