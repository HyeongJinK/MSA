package com.illunex.invest.api.core.user.controller;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "비밀번호 변경")
@RequestMapping("/changePassword")
public interface PasswordChangeController {
    ResponseEntity<String> changePassword(@RequestParam String username
        , @RequestParam String password);
}
