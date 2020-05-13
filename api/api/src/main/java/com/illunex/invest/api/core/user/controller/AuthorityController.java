package com.illunex.invest.api.core.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.user.dto.AuthorityDTO;
import com.illunex.invest.api.core.user.request.AuthorityRequest;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "권한설정")
@RequestMapping("/authority")
public interface AuthorityController {
    @PostMapping({"", "/"})
    ResponseEntity<ResponseData> setMemberAuthority(@RequestBody AuthorityRequest request);
    @GetMapping("/{companyIdx}")
    ResponseEntity<ResponseList> getMemberAuthorityList(@PathVariable("companyIdx") Long companyIdx);
    @GetMapping("list/{companyIdx}")
    ResponseEntity<List<AuthorityDTO>> getAuthorityList(@PathVariable("companyIdx") Long companyIdx);
    @GetMapping("/ir")
    ResponseEntity<AuthorityDTO> getIRAuthority(@RequestParam Long userIdx);
}
