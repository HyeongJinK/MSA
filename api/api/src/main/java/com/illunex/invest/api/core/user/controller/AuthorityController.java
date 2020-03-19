package com.illunex.invest.api.core.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.user.model.AuthorityRequest;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "권한설정")
@RequestMapping("/authority")
public interface AuthorityController {
    @GetMapping({"", "/"})
    ResponseEntity<ResponseList> getMemberAuthorityList(@RequestParam("companyIdx") Long companyIdx);
    @PostMapping({"", "/"})
    ResponseEntity<ResponseData> setMemberAuthority(@RequestBody AuthorityRequest request);

}
