package com.illunex.invest.api.composite.startup.mypage.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.user.request.AuthorityRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "마이페이지 권한설정")
@RequestMapping(value = "/myPage/authority")
public interface AuthorityCompositeController {
    @ApiOperation(value = "회사 유저 권한 조회")
    @GetMapping
    ResponseEntity<ResponseList> getMemberAuthorityList();
    @ApiOperation(value = "권한 수정")
    @PostMapping
    ResponseEntity<ResponseData> editMemberAuthority(@RequestBody AuthorityRequest request);
}
