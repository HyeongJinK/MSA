package com.illunex.invest.api.composite.startup.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.MemberDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/company/member")
public interface MemberCompositeController {
    @GetMapping(value = {"", "/", "/list"})
    ResponseEntity<ResponseData> memberList();
    @PostMapping(value = "/form")
    ResponseEntity<ResponseData> editMember(@RequestBody MemberDTO memberDTO);
    @GetMapping(value = "/{id}")
    ResponseEntity<ResponseData> readMember(@PathVariable Long id);
    @DeleteMapping(value = "/{id}")
    ResponseEntity<ResponseData> deleteMember(@PathVariable Long id);
}
