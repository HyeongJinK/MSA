package com.illunex.invest.api.composite.startup.user.controller;

import com.illunex.invest.api.composite.startup.user.model.SignUpRequest;
import com.illunex.invest.api.core.user.model.ChangePasswordRequest;
import com.illunex.invest.api.core.user.model.JwtResponse;
import com.illunex.invest.api.core.user.model.MyPageChangePasswordRequest;
import com.illunex.invest.api.core.user.model.SignInRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RequestMapping(value = "/user")
public interface UserCompositeController {
    @PostMapping(value = "/signUp")
    ResponseEntity<HashMap<String, Object>> signUp(@RequestBody SignUpRequest signUpRequest);
    @PostMapping(value = "/signIn")
    ResponseEntity<JwtResponse> signIn(@RequestBody SignInRequest signInRequest);
    @PostMapping(value = "/changePassword")
    ResponseEntity<HashMap<String, Object>> changePassword(@RequestBody MyPageChangePasswordRequest request);
}
