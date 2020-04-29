package com.illunex.invest.api.composite.startup.mypage.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.user.dto.UserDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "마이페이지 프로")
@RequestMapping(value = "/myPage/profile")
public interface ProfileCompositeController {
    @GetMapping(value = {"", "/"})
    ResponseEntity<ResponseData> getProfile();
    @PostMapping(value = {"", "/"})
    ResponseEntity<ResponseData> editProfile(@RequestBody UserDTO userDTO);
}
