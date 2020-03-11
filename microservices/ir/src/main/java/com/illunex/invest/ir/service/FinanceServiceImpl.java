package com.illunex.invest.ir.service;

import com.illunex.invest.api.core.ir.dto.FinanceDTO;
import com.illunex.invest.ir.persistence.entity.FinanceEntity;
import com.illunex.invest.ir.persistence.entity.FinancialStatusEntity;
import com.illunex.invest.ir.persistence.entity.IREntity;
import com.illunex.invest.ir.persistence.repository.FinanceRepository;
import com.illunex.invest.ir.persistence.repository.FinancialStatusRepository;
import com.illunex.invest.ir.service.mapper.FinanceMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FinanceServiceImpl extends CommonIRService<FinanceDTO> {
    private Log log = LogFactory.getLog(FinanceServiceImpl.class);
    private FinanceMapper financeMapper = Mappers.getMapper(FinanceMapper.class);

    @Autowired
    FinanceRepository financeRepository;
    @Autowired
    FinancialStatusRepository financialStatusRepository;

    @Override
    public FinanceDTO get(Long irIdx) {
        FinanceEntity finance = financeRepository.findByIrIdx(irIdx);

        return financeMapper.entityToDto(finance);
    }

    @Override
    @Transactional
    public String edit(FinanceDTO financeDTO) {
        FinanceEntity financeEntity = financeMapper.dtoToEntity(financeDTO);
        IREntity ir = irRepository.findById(financeDTO.getIrIdx()).orElse(null);

        return editTemplate(ir, () -> {
            financeEntity.setIdx(ir.getFinance().getIdx());
            editFinancialStatus(financeEntity);
            financeRepository.save(financeEntity);
        }, "Cannot edit Finance. Invalid IR Index."
        , "Finance edit success");
    }

    private void editFinancialStatus(FinanceEntity financeEntity) {
        financialStatusRepository.deleteAllByFinanceIdx(financeEntity.getIdx());
        for (FinancialStatusEntity s: financeEntity.getFinancialStatus()){
            s.setFinance(financeEntity);
        }
    }
}
