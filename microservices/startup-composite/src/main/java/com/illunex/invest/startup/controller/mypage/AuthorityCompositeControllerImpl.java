package com.illunex.invest.startup.controller.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.mypage.controller.AuthorityCompositeController;
import com.illunex.invest.api.composite.startup.mypage.dto.AuthorityExDTO;
import com.illunex.invest.api.core.shop.dto.PluginDTO;
import com.illunex.invest.api.core.user.request.AuthorityRequest;
import com.illunex.invest.startup.controller.StartupDefaultController;
import com.illunex.invest.startup.service.mypage.AuthorityIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorityCompositeControllerImpl extends StartupDefaultController implements AuthorityCompositeController {
    private final AuthorityIntegrationService authorityIntegrationService;

    @Override
    public ResponseEntity<ResponseData> getMemberAuthorityList() {
        return ResponseEntity.ok(ResponseData.builder()
                        .errorCode(0)
                        .message("success")
                        .data(authorityIntegrationService.getAuthorityList())
                        .build());
    }

    @Override
    public ResponseEntity<ResponseData> editMemberAuthority(AuthorityRequest request) {
        return authorityIntegrationService.edit(request);
    }

    @Override
    public ResponseEntity<ResponseData> getAuthority() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData> updateAuthority() {
        return null;
    }

    @Override
    public ResponseEntity<List<AuthorityExDTO>> getAuthorityUserList() {
        return ResponseEntity.ok(authorityIntegrationService.getUserList());
    }
}

