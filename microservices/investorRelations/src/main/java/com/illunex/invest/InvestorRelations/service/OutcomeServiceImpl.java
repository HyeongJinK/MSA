package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.entity.*;
import com.illunex.invest.InvestorRelations.persistence.repository.*;
import com.illunex.invest.InvestorRelations.service.mapper.OutcomeMapper;
import com.illunex.invest.api.core.InvestorRelations.dto.OutcomeDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OutcomeServiceImpl implements CommonIRService<OutcomeDTO> {
    private Log log = LogFactory.getLog(OutcomeServiceImpl.class);
    private OutcomeMapper outcomeMapper = Mappers.getMapper(OutcomeMapper.class);

    @Autowired
    OutcomeRepository outcomeRepository;
    @Autowired
    IRRepository irRepository;
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
    public OutcomeDTO edit(OutcomeDTO outcomeDTO) {
        OutcomeEntity outcomeEntity = outcomeMapper.dtoToEntity(outcomeDTO);


        if (irRepository.findById(outcomeDTO.getIrIdx()).isEmpty()) {
            return OutcomeDTO.builder().content("unavailable").build();
        } else {
            Long irIdx = outcomeDTO.getIrIdx();
            outcomeEntity.setIdx(irRepository.findById(irIdx).get().getOutcome().getIdx());

            investRepository.deleteAllByOutcomeIdx(outcomeEntity.getIdx());
            awardRepository.deleteAllByOutcomeIdx(outcomeEntity.getIdx());
            exportRepository.deleteAllByOutcomeIdx(outcomeEntity.getIdx());
            fundRepository.deleteAllByOutcomeIdx(outcomeEntity.getIdx());
            planRepository.deleteAllByOutcomeIdx(outcomeEntity.getIdx());

            List<InvestEntity> investEntities = outcomeEntity.getInvest();
            List<AwardEntity> awardEntities = outcomeEntity.getAward();
            List<ExportEntity> exportEntities = outcomeEntity.getExport();
            List<FundEntity> fundEntities = outcomeEntity.getFund();
            List<PlanEntity> planEntities = outcomeEntity.getPlan();

            for (InvestEntity i: investEntities) {
                i.setOutcome(outcomeEntity);
            }
            for (AwardEntity a: awardEntities) {
                a.setOutcome(outcomeEntity);
            }
            for (ExportEntity e: exportEntities) {
                e.setOutcome(outcomeEntity);
            }
            for (FundEntity f: fundEntities) {
                f.setOutcome(outcomeEntity);
            }
            for (PlanEntity p: planEntities) {
                p.setOutcome(outcomeEntity);
            }

            OutcomeEntity result = outcomeRepository.save(outcomeEntity);

            IREntity ir = irRepository.findById(irIdx).get();
            Progress progress = new Progress();
            String res = progress.progressCalculate(ir);
            ir.setProgress(res);
            ir.setUpdateDate(LocalDateTime.now());
            irRepository.save(ir);

            return outcomeMapper.entityToDto(result);
        }
    }

}
