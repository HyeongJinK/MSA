package com.illunex.invest.api.composite.startup.mypage.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.mypage.dto.AuthorityExDTO;
import com.illunex.invest.api.core.shop.dto.PluginDTO;
import com.illunex.invest.api.core.user.request.AuthorityRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "마이페이지 권한설정")
@RequestMapping(value = "/myPage/authority")
public interface AuthorityCompositeController {
    @ApiOperation(value = "회사 유저 권한 조회")
    @GetMapping
    ResponseEntity<ResponseData> getMemberAuthorityList(@RequestParam Long userId);
    @ApiOperation(value = "권한 수정")
    @PostMapping
    ResponseEntity<ResponseData> editMemberAuthority(@RequestBody AuthorityRequest request);
    // 사용자 별로 권한 불러오기
    @GetMapping(value = "/getAuthority")
    ResponseEntity<ResponseData> getAuthority();
    // 사용자 별로 수정하기
    @PostMapping(value = "/updateAuthority")
    ResponseEntity<ResponseData> updateAuthority();


    @GetMapping(value = "/getUserList")
    ResponseEntity<List<AuthorityExDTO>> getAuthorityUserList();
}
