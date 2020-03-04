package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.entity.IREntity;
import com.illunex.invest.InvestorRelations.persistence.entity.MemberEntity;
import com.illunex.invest.InvestorRelations.persistence.repository.IRRepository;
import com.illunex.invest.InvestorRelations.persistence.repository.MemberRepository;
import com.illunex.invest.InvestorRelations.service.mapper.MemberMapper;
import com.illunex.invest.api.core.InvestorRelations.dto.MemberDTO;
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
    public List<MemberDTO> getList(Long irIdx) {
        List<MemberEntity> memberEntities = memberRepository.findAllByIrIdx(irIdx);

        return memberMapper.memberEntityListToDto(memberEntities);
    }

    @Override
    @Transactional
    public List<MemberDTO> editList(List<MemberDTO> infoList) {
        List<MemberEntity> memberEntities = memberMapper.memberDtoListToEntity(infoList);

        if (irRepository.findById(infoList.get(0).getIrIdx()).isEmpty()) {
            List<MemberEntity> historyEntityList = new ArrayList<>();
            historyEntityList.add(MemberEntity.builder().name("unavailable").build());

            return memberMapper.memberEntityListToDto(historyEntityList);
        } else {
            Long irIdx = infoList.get(0).getIrIdx();

            memberRepository.deleteAllByIrIdx(irIdx);
            IREntity irEntity = irRepository.findById(irIdx).get();

            for (MemberEntity h: memberEntities) {
                h.setIr(irEntity);
            }

            List<MemberEntity> result = memberRepository.saveAll(memberEntities);

            IREntity ir = irRepository.findById(irIdx).get();
            Progress progress = new Progress();
            String res = progress.progressCalculate(ir);
            ir.setProgress(res);
            ir.setUpdateDate(LocalDateTime.now());
            irRepository.save(ir);

            return memberMapper.memberEntityListToDto(result);
        }

    }
}
