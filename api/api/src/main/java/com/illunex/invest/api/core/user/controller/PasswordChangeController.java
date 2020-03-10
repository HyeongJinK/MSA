package com.illunex.invest.api.core.user.controller;

import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.model.ChangePasswordRequest;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "비밀번호 변경")
@RequestMapping("/changePassword")
public interface PasswordChangeController {
    ResponseEntity<UserDTO> changePassword(@RequestBody ChangePasswordRequest request);
}
