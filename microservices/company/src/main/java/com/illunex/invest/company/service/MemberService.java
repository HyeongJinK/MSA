package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    List<MemberDTO> getMembers(Long companyIdx);
    MemberDTO getMember(Long id);
    void editMember(MemberDTO memberDTO);
    void editMembers(List<MemberDTO> memberDTOS);
    void deleteMember(Long id);
}
