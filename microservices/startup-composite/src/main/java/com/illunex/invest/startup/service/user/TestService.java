package com.illunex.invest.startup.service.user;

import com.illunex.invest.api.core.user.model.JwtResponse;
import com.illunex.invest.api.core.user.model.SignInRequest;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient(name = "gateway")
//@RibbonClient(name = "user")
public interface TestService {
//    @PostMapping(value = "/user/signIn")
//    ResponseEntity<JwtResponse> signIn(SignInRequest signInRequest);
}
