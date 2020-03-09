package com.illunex.invest.user.controller;

import com.illunex.invest.api.core.user.controller.CertificationController;
import com.illunex.invest.user.exception.UsernameNotFoundException;
import com.illunex.invest.user.service.CertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CertificationControllerImpl implements CertificationController {
    private final CertificationService certificationService;

    @Override
    public ResponseEntity<Map<String, Object>> certification(String token) {
        return new ResponseEntity<>(certificationService.certification(token), HttpStatus.OK);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<HashMap<String, Object>> UsernameNotFoundException(UsernameNotFoundException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", "아이디를 입력해주세요");

        return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
    }
}
