package com.illunex.invest.api.composite.startup.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.user.request.SignUpRequest;
import com.illunex.invest.api.core.user.request.SignInRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/user")
public interface UserCompositeController {
    @PostMapping(value = "/signUp")
    ResponseEntity<ResponseData> signUp(@RequestBody SignUpRequest signUpRequest);
    @PostMapping(value = "/signIn")
    ResponseEntity<ResponseData> signIn(@RequestBody SignInRequest signInRequest);
    @PostMapping(value = "/invite")
    ResponseEntity<ResponseData> invite(@RequestBody SignUpRequest signUpRequest);
    @GetMapping(value = "/expire")
    ResponseEntity<ResponseData> expire();
}
