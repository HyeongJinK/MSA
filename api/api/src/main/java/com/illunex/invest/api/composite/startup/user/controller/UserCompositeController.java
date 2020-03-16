package com.illunex.invest.api.composite.startup.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseListData;
import com.illunex.invest.api.composite.startup.user.model.SignUpRequest;
import com.illunex.invest.api.core.user.model.ChangePasswordRequest;
import com.illunex.invest.api.core.user.model.JwtResponse;
import com.illunex.invest.api.core.user.model.MyPageChangePasswordRequest;
import com.illunex.invest.api.core.user.model.SignInRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RequestMapping(value = "/user")
public interface UserCompositeController {
    @PostMapping(value = "/signUp")
    ResponseEntity<ResponseData> signUp(@RequestBody SignUpRequest signUpRequest);
    @PostMapping(value = "/signIn")
    ResponseEntity<ResponseData> signIn(@RequestBody SignInRequest signInRequest);
    @PostMapping(value = "/changePassword")
    ResponseEntity<ResponseData> changePassword(@RequestBody MyPageChangePasswordRequest request);
    @GetMapping(value = "/signature")
    ResponseEntity<ResponseListData> signature();
    @PostMapping(value = "/signature")
    ResponseEntity<ResponseData> signature(@RequestParam("file") MultipartFile file);
}
