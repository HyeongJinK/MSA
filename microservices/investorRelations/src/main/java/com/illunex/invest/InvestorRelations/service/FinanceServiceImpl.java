package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.entity.*;
import com.illunex.invest.InvestorRelations.persistence.repository.*;
import com.illunex.invest.InvestorRelations.service.mapper.FinanceMapper;
import com.illunex.invest.api.core.InvestorRelations.dto.FinanceDTO;
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
public class FinanceServiceImpl implements CommonIRService<FinanceDTO> {
    private Log log = LogFactory.getLog(FinanceServiceImpl.class);
    private FinanceMapper financeMapper = Mappers.getMapper(FinanceMapper.class);

    @Autowired
    FinanceRepository financeRepository;
    @Autowired
    IRRepository irRepository;
    @Autowired
    FinancialStatusRepository financialStatusRepository;

    @Override
    public FinanceDTO get(Long irIdx) {
        FinanceEntity finance = financeRepository.findByIrIdx(irIdx);

        return financeMapper.entityToDto(finance);
    }

    @Override
    @Transactional
    public FinanceDTO edit(FinanceDTO financeDTO) {
        FinanceEntity finance = financeMapper.dtoToEntity(financeDTO);


        if (irRepository.findById(financeDTO.getIrIdx()).isEmpty()) {
            return FinanceDTO.builder().tax("unavailable").build();
        } else {
            Long irIdx = financeDTO.getIrIdx();
            finance.setIdx(irRepository.findById(irIdx).get().getFinance().getIdx());

            financialStatusRepository.deleteAllByFinanceIdx(finance.getIdx());

            List<FinancialStatusEntity> financialStatusEntities = finance.getFinancialStatus();

            for (FinancialStatusEntity f: financialStatusEntities) {
                f.setFinance(finance);
            }

            FinanceEntity result = financeRepository.save(finance);

            IREntity ir = irRepository.findById(irIdx).get();
            Progress progress = new Progress();
            String res = progress.progressCalculate(ir);
            ir.setProgress(res);
            irRepository.save(ir);

            return financeMapper.entityToDto(result);
        }
    }
}
