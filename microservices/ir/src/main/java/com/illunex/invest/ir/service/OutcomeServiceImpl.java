package com.illunex.invest.ir.service;

import com.illunex.invest.api.core.ir.dto.OutcomeDTO;
import com.illunex.invest.ir.persistence.entity.*;
import com.illunex.invest.ir.persistence.repository.*;
import com.illunex.invest.ir.service.mapper.OutcomeMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OutcomeServiceImpl extends CommonIRService<OutcomeDTO> {
    private Log log = LogFactory.getLog(OutcomeServiceImpl.class);
    private OutcomeMapper outcomeMapper = Mappers.getMapper(OutcomeMapper.class);

    @Autowired
    OutcomeRepository outcomeRepository;
    @Autowired
    InvestRepository investRepository;
    @Autowired
    AwardRepository awardRepository;
    @Autowired
    ExportRepository exportRepository;
    @Autowired
    FundRepository fundRepository;
    @Autowired
    PlanRepository planRepository;

    @Override
    public OutcomeDTO get(Long irIdx) {
        OutcomeEntity outcomeInfo = outcomeRepository.findByIrIdx(irIdx);

        return outcomeMapper.entityToDto(outcomeInfo);
    }

    @Override
    @Transactional
    public String edit(OutcomeDTO outcomeDTO) {
        OutcomeEntity outcomeEntity = outcomeMapper.dtoToEntity(outcomeDTO);
        IREntity ir = irRepository.findById(outcomeDTO.getIrIdx()).orElse(null);

        return editTemplate(ir, () -> {
            outcomeEntity.setIdx(ir.getOutcome().getIdx());
            editInvest(outcomeEntity);
            editAward(outcomeEntity);
            editExport(outcomeEntity);
            editFund(outcomeEntity);
            editPlan(outcomeEntity);
            outcomeRepository.save(outcomeEntity);
        }, "Cannot edit outcome. Invalid IR Index."
        , "outcome edit success");
    }

    private void editInvest(OutcomeEntity outcomeEntity) {
        investRepository.deleteAllByOutcomeIdx(outcomeEntity.getIdx());
        for (InvestEntity s: outcomeEntity.getInvest()){
            s.setOutcome(outcomeEntity);
        }
    }

    private void editAward(OutcomeEntity outcomeEntity) {
        awardRepository.deleteAllByOutcomeIdx(outcomeEntity.getIdx());
        for (AwardEntity s: outcomeEntity.getAward()){
            s.setOutcome(outcomeEntity);
        }
    }

    private void editExport(OutcomeEntity outcomeEntity) {
        exportRepository.deleteAllByOutcomeIdx(outcomeEntity.getIdx());
        for (ExportEntity s: outcomeEntity.getExport()){
            s.setOutcome(outcomeEntity);
        }
    }

    private void editFund(OutcomeEntity outcomeEntity) {
        fundRepository.deleteAllByOutcomeIdx(outcomeEntity.getIdx());
        for (FundEntity s: outcomeEntity.getFund()){
            s.setOutcome(outcomeEntity);
        }
    }

    private void editPlan(OutcomeEntity outcomeEntity) {
        planRepository.deleteAllByOutcomeIdx(outcomeEntity.getIdx());
        for (PlanEntity s: outcomeEntity.getPlan()){
            s.setOutcome(outcomeEntity);
        }
    }

}
