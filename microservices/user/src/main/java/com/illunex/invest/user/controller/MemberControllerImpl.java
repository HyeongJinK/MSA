package com.illunex.invest.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.user.controller.MemberController;
import com.illunex.invest.user.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberControllerImpl implements MemberController {
    private final TeamService teamService;

    @Override
    public ResponseEntity<ResponseList> getMembers(Long companyIdx) {
        return ResponseEntity.ok(new ResponseList<>(0, "success", teamService.findAllByCompanyIdx(companyIdx)));
    }

    @Override
    public ResponseEntity<ResponseData> deleteMember(Long id) {
        teamService.deleteUser(id);
        return ResponseEntity.ok(ResponseData.builder()
                .message("success")
                .errorCode(0)
                .build());
    }
}
