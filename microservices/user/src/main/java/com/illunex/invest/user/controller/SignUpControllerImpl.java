package com.illunex.invest.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.user.controller.SignUpController;
import com.illunex.invest.api.core.user.dto.AuthorityDTO;
import com.illunex.invest.api.core.user.request.SignUpRequest;
import com.illunex.invest.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignUpControllerImpl extends UserDefaultController implements SignUpController {
    private final SignUpService signUpService;

    @Override
    public ResponseEntity<ResponseData> signUp(SignUpRequest signUpRequest) {
        return ResponseEntity.ok(ResponseData.builder()
                    .errorCode(0)
                    .data(signUpService.signUp(signUpRequest.getUsername()
                        , signUpRequest.getPassword()
                        , signUpRequest.getName()
                        , signUpRequest.getVender()
                        , signUpRequest.getCompanyIdx()))
                    .build());
    }

    @Override
    public ResponseEntity<ResponseList> list(Long companyIdx) {
        ResponseList<AuthorityDTO> data = new ResponseList(0
                , "success"
                , signUpService.findByCompanyIdx(companyIdx));

        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<ResponseData> invite(SignUpRequest signUpRequest) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .data(signUpService.invite(signUpRequest.getUsername()
                        , signUpRequest.getPassword()
                        , signUpRequest.getName()
                        , signUpRequest.getVender()
                        , signUpRequest.getCompanyIdx()))
                .build());
    }
}
