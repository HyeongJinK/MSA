package com.illunex.invest.api.core.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "팀원초대")
@RequestMapping("/member")
public interface MemberController {
    @GetMapping
    ResponseEntity<ResponseList> getMembers(@RequestParam Long companyIdx);
    @DeleteMapping
    ResponseEntity<ResponseData> deleteMember(@RequestParam Long id);
}
