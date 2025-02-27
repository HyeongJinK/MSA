package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.MemberDTO;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.Member;
import com.illunex.invest.company.persistence.repository.MemberRepository;
import com.illunex.invest.company.service.mapper.MemberMapper;
import io.micrometer.core.instrument.util.JsonUtils;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {
    private MemberMapper mapper = Mappers.getMapper(MemberMapper.class);
    private final MemberRepository memberRepository;

    @Override
    public List<MemberDTO> getMembers(Long companyIdx) {
        return mapper.entityToDto(memberRepository.findByCompanyCompanyIdx(companyIdx));
    }

    @Override
    public MemberDTO getMember(Long id) {
        return mapper.entityToDto(memberRepository.findById(id).get());
    }

    @Override
    @Transactional
    public void editMember(MemberDTO memberDTO) {
        memberRepository.save(mapper.dtoToEntity(memberDTO));
    }

    @Override
    @Transactional
    public void editMembers(List<MemberDTO> memberDTOS) {
        List<Member> list = mapper.dtoToEntity(memberDTOS);
        memberRepository.deleteByCompanyCompanyIdx(list.get(0).getCompany().getCompanyIdx());
        memberRepository.saveAll(list);
    }

    @Override
    @Transactional
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
