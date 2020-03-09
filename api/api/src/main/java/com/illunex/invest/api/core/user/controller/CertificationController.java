package com.illunex.invest.api.core.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(value = "/certification")
public interface CertificationController {
    @PostMapping({"", "/"})
    ResponseEntity<Map<String, Object>> certification(String token);
}
