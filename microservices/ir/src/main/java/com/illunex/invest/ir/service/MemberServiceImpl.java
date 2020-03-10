package com.illunex.invest.ir.service;

import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.api.core.ir.dto.MemberDTO;
import com.illunex.invest.ir.persistence.entity.IREntity;
import com.illunex.invest.ir.persistence.entity.MemberEntity;
import com.illunex.invest.ir.persistence.repository.MemberRepository;
import com.illunex.invest.ir.service.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl extends CommonIRListService<MemberDTO> {
    private Log log = LogFactory.getLog(MemberServiceImpl.class);
    private MemberMapper memberMapper = Mappers.getMapper(MemberMapper.class);

    @Autowired
    MemberRepository memberRepository;

    @Override
    public ListDTO getList(Long irIdx) {
        List<MemberEntity> memberEntities = memberRepository.findAllByIrIdx(irIdx);
        List<MemberDTO> result = memberMapper.memberEntityListToDto(memberEntities);
        return ListDTO.builder().memberList(result).build();
    }

    @Override
    @Transactional
    public String editList(Long irIdx, List<MemberDTO> infoList) {
        List<MemberEntity> memberEntities = memberMapper.memberDtoListToEntity(infoList);
        IREntity ir = irRepository.findById(irIdx).orElse(null);

        return editTemplate(ir, () -> {
            editMember(ir, memberEntities);
            memberRepository.saveAll(memberEntities);
        }, "Cannot edit Member. Invalid IR Index."
        , "Member edit success");
    }

    private void editMember(IREntity irEntity, List<MemberEntity> memberEntities) {
        memberRepository.deleteAllByIrIdx(irEntity.getIdx());
        for (MemberEntity s: memberEntities){
            s.setIr(irEntity);
        }
    }
}
