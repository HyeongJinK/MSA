package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.core.company.dto.MemberDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "멤버 API")
@RequestMapping(value = "/member")
public interface MemberController {
    @PostMapping
    ResponseEntity<String> editMember(@RequestBody MemberDTO memberDTO);
    @GetMapping(value = "/{companyId}")
    ResponseEntity<List<MemberDTO>> getMember(@PathVariable Long companyId);
    @DeleteMapping(value = "/{id}")
    ResponseEntity<String> deleteMember(@PathVariable("id") Long id);
}
