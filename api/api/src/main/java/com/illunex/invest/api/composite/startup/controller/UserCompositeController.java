package com.illunex.invest.api.composite.startup.controller;

import com.illunex.invest.api.core.user.model.JwtResponse;
import com.illunex.invest.api.core.user.model.SignInRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserCompositeController {
    @PostMapping(value = "/signIn")
    ResponseEntity<JwtResponse> signIn(@RequestBody SignInRequest signInRequest);
}
