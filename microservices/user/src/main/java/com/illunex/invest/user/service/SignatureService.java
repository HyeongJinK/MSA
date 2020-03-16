package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.SignatureDTO;
import com.illunex.invest.api.core.user.model.SignatureRequest;

import java.util.List;

public interface SignatureService {
    List<SignatureDTO> signatureList(Long userId);
    SignatureDTO addSignature(SignatureRequest request);
}
