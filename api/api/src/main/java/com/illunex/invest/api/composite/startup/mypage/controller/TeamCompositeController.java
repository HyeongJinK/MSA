package com.illunex.invest.api.composite.startup.mypage.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "팀원연결")
@RequestMapping(value = "/myPage/team")
public interface TeamCompositeController {
    @GetMapping
    ResponseEntity<ResponseList> getMembers();
    @DeleteMapping
    ResponseEntity<ResponseData> deleteMember(@RequestParam Long id);
}
