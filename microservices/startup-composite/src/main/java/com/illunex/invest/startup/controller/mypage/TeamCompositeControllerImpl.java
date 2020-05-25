package com.illunex.invest.startup.controller.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.mypage.controller.TeamCompositeController;
import com.illunex.invest.startup.controller.StartupDefaultController;
import com.illunex.invest.startup.service.mypage.TeamIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamCompositeControllerImpl extends StartupDefaultController implements TeamCompositeController {
    private final TeamIntegrationService teamIntegrationService;

    @Override
    public ResponseEntity<ResponseList> getMembers() {
        return teamIntegrationService.getMembers();
    }

    @Override
    public ResponseEntity<ResponseData> deleteMember(Long id) {
        return teamIntegrationService.deleteMember(id);
    }
}
