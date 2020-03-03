package com.illunex.invest.startup.controller.user;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.user.model.JwtResponse;
import com.illunex.invest.api.core.user.model.SignInRequest;
import com.illunex.invest.startup.service.user.Test2Service;
import com.illunex.invest.startup.service.user.TestService;
import com.illunex.invest.startup.service.user.UserCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserCompositeIntegration userCompositeIntegration;
   // private final TestService testService;
    private final Test2Service test2Service;

    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }

    @GetMapping(value = "/test2")
    public String test2() {
        SignInRequest request = new SignInRequest("test", "password");
        ResponseEntity<JwtResponse> jwtResponseResponseEntity = userCompositeIntegration.signIn(request);

        return jwtResponseResponseEntity.getBody().getJwtToken();
    }

    @GetMapping(value = "/test3")
    public String test3() {
        CompanyDTO data = userCompositeIntegration.getCompanyByUserIdx(1L);

        return data.getName();
    }

//    @GetMapping(value = "/test4")
//    public String test4() {
//        SignInRequest request = new SignInRequest("test", "password");
//        ResponseEntity<JwtResponse> jwtResponseResponseEntity = testService.signIn(request);
//
//        return jwtResponseResponseEntity.getBody().getJwtToken();
//    }

    @GetMapping(value = "/test5")
    public String test5() {
        ResponseEntity<CompanyDTO> companyByUserIdx = test2Service.getCompanyByUserIdx();

        return companyByUserIdx.getBody().getName();
    }
}
