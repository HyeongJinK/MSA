package com.illunex.invest.api.composite.startup.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.user.request.SignUpRequest;
import com.illunex.invest.api.core.user.request.MyPageChangePasswordRequest;
import com.illunex.invest.api.core.user.request.SignInRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value = "/user")
public interface UserCompositeController {
    @PostMapping(value = "/signUp")
    ResponseEntity<ResponseData> signUp(@RequestBody SignUpRequest signUpRequest);
    @PostMapping(value = "/signIn")
    ResponseEntity<ResponseData> signIn(@RequestBody SignInRequest signInRequest);
    @PostMapping(value = "/changePassword")
    ResponseEntity<ResponseData> changePassword(@RequestBody MyPageChangePasswordRequest request);
    @GetMapping(value = "/signature")
    ResponseEntity<ResponseList> signature();
    @PostMapping(value = "/signature")
    ResponseEntity<ResponseData> signature(@RequestParam("file") MultipartFile file);
    @PutMapping(value = "/signature")
    ResponseEntity<ResponseData> toggleSignature(@RequestParam Long id);
    @DeleteMapping(value = "/signature")
    ResponseEntity<ResponseData> delSignature(@RequestParam Long id);
}
