package com.illunex.invest.user.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface SignatureService {
    public void addSignature(MultipartFile file, Long userId);
}
