package com.illunex.invest.api.composite.startup.mypage.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.mypage.request.MyPageChangePasswordRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "마이페이지 비밀번호 수정")
@RequestMapping(value = "/myPage/changePassword")
public interface PasswordCompositeController {
    @ApiOperation(value = "비밀번호 수정")
    @PostMapping
    ResponseEntity<ResponseData> changePassword(@RequestBody MyPageChangePasswordRequest request);
}
