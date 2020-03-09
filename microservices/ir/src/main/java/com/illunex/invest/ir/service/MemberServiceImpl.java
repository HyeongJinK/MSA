package com.illunex.invest.ir.service;

import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.ir.persistence.entity.IREntity;
import com.illunex.invest.ir.persistence.entity.MemberEntity;
import com.illunex.invest.ir.persistence.repository.IRRepository;
import com.illunex.invest.ir.persistence.repository.MemberRepository;
import com.illunex.invest.ir.service.mapper.MemberMapper;
import com.illunex.invest.api.core.ir.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements CommonIRListService<MemberDTO> {
    private Log log = LogFactory.getLog(MemberServiceImpl.class);
    private MemberMapper memberMapper = Mappers.getMapper(MemberMapper.class);

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    IRRepository irRepository;

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

        if (irRepository.findById(irIdx).isEmpty()) {
            return "Cannot edit member. Invalid IR Index.";
        } else {
            memberRepository.deleteAllByIrIdx(irIdx);
            IREntity irEntity = irRepository.findById(irIdx).get();

            for (MemberEntity h: memberEntities) {
                h.setIr(irEntity);
            }

            memberRepository.saveAll(memberEntities);

            IREntity ir = irRepository.findById(irIdx).get();
            Progress progress = new Progress();
            String res = progress.progressCalculate(ir);
            ir.setProgress(res);
            ir.setUpdateDate(LocalDateTime.now());
            irRepository.save(ir);

            return "member edit complete";
        }

    }
}
