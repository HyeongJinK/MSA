package com.illunex.invest.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.user.controller.AuthorityController;
import com.illunex.invest.api.core.user.dto.AuthorityDTO;
import com.illunex.invest.api.core.user.request.AuthorityRequest;
import com.illunex.invest.user.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorityControllerImpl extends UserDefaultController  implements AuthorityController {
    private final AuthorityService authorityService;

    @Override
    public ResponseEntity<ResponseList> getMemberAuthorityList(Long companyIdx) {

        ResponseList<AuthorityDTO> data = new ResponseList(0
                , "success"
                , authorityService.getMemberAuthorityList(companyIdx));

        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<List<AuthorityDTO>> getAuthorityList(Long companyIdx) {
        return ResponseEntity.ok(authorityService.getMemberAuthorityList(companyIdx));
    }

    @Override
    public ResponseEntity<AuthorityDTO> getIRAuthority(Long userIdx) {
        return new ResponseEntity(authorityService.getIRAuthority(userIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseData> setMemberAuthority(AuthorityRequest request) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(authorityService.setMemberAuthorityList(request))
                .build());
    }
}
