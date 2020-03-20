package com.illunex.invest.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.user.controller.AuthorityController;
import com.illunex.invest.api.core.user.dto.AuthorityDTO;
import com.illunex.invest.api.core.user.request.AuthorityRequest;
import com.illunex.invest.user.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorityControllerImpl extends UserDefaultController  implements AuthorityController {
    private final AuthorityService authorityService;

    @Override
    public ResponseEntity<ResponseList> getMemberAuthorityList(Long companyIdx) {
        ResponseList<AuthorityDTO> data = new ResponseList(0
                , "success"
                , authorityService.getMemberAuthorityList(companyIdx));
        ResponseEntity.ok(data);

        return null;
    }

    @Override
    public ResponseEntity<ResponseData> setMemberAuthority(AuthorityRequest request) {
        return null;
    }
}
