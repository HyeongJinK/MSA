package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.entity.BasicInfoEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.FinanceEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.IREntity;
import com.illunex.invest.InvestorRelations.persistence.repository.IRRepository;
import com.illunex.invest.InvestorRelations.service.mapper.IRMapper;
import com.illunex.invest.api.core.InvestorRelations.dto.IRDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class IRService {
    private Log log = LogFactory.getLog(IRService.class);
    private IRMapper irMapper = Mappers.getMapper(IRMapper.class);

    @Autowired
    IRRepository irRepository;

    public List<IRDTO> getList(Long companyIdx) {
        String year = String.valueOf(LocalDateTime.now().getYear());
        IREntity currentYearIR = irRepository.findByCompanyIdxAndYear(companyIdx, year);

        if (currentYearIR == null) {
            BasicInfoEntity basicInfoEntity = BasicInfoEntity.builder()
                    .build();
            FinanceEntity financeEntity = FinanceEntity.builder()
                    .build();
            IREntity irEntity = IREntity.builder()
                    .companyIdx(companyIdx)
                    .cardColor(setColor())
                    .basicInfo(basicInfoEntity)
                    .finance(financeEntity)
                    .build();
            basicInfoEntity.setIr(irEntity);

            irRepository.save(irEntity);
        }
        return irMapper.entityListToDtoList(irRepository.findAllByCompanyIdx(companyIdx));
    }

    private String setColor() {
        return "#000000";
    }
}
