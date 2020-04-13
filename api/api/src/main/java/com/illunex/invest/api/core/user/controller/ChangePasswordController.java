package com.illunex.invest.api.core.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.user.request.ChangePasswordRequest;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "비밀번호 변경")
@RequestMapping("/changePassword")
public interface ChangePasswordController {
    @PostMapping({"", "/"})
    ResponseEntity<ResponseData> changePassword(@RequestBody ChangePasswordRequest request);

}
