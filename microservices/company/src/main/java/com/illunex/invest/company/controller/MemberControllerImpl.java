package com.illunex.invest.company.controller;

import com.illunex.invest.api.core.company.controller.MemberController;
import com.illunex.invest.api.core.company.dto.MemberDTO;
import com.illunex.invest.company.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberControllerImpl implements MemberController {
    private final Logger log = LoggerFactory.getLogger(MemberControllerImpl.class);
    private final MemberService memberService;

    @Override
    public ResponseEntity<String> editMember(MemberDTO memberDTO) {
        memberService.editMember(memberDTO);
        return ResponseEntity.ok("success");
    }

    @Override
    public ResponseEntity<String> editMembers(List<MemberDTO> memberDTOS) {
        memberService.editMembers(memberDTOS);
        return ResponseEntity.ok("success");
    }

    @Override
    public ResponseEntity<String> deleteMember(Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("success");
    }

    @Override
    public ResponseEntity<List<MemberDTO>> getMember(Long companyId) {
        log.debug("===============getMember==============");
        log.debug(companyId.toString());
        return ResponseEntity.ok(memberService.getMembers(companyId));
    }
}
