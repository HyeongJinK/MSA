package com.illunex.invest.api.composite.startup.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.user.request.InviteRequest;
import com.illunex.invest.api.composite.startup.user.request.SignUpRequest;
import com.illunex.invest.api.core.user.request.SignInRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/user")
public interface UserCompositeController {
    @PostMapping(value = "/signUp")
    ResponseEntity<ResponseData> signUp(@RequestBody SignUpRequest signUpRequest);
    @PostMapping(value = "/signIn")
    ResponseEntity<ResponseData> signIn(@RequestBody SignInRequest signInRequest);
    @GetMapping(value = "/list")
    ResponseEntity<ResponseList> list();
    @PostMapping(value = "/invite")
    ResponseEntity<ResponseData> invite(@RequestBody InviteRequest inviteRequest);
    @GetMapping(value = "/expire")
    ResponseEntity<ResponseData> expire();
    @GetMapping(value = "/certification")
    ResponseEntity<ResponseData> certification(@RequestParam String token);
}
