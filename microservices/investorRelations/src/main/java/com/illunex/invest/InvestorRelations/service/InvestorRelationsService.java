package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.entity.CompanyInfoEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.InvestorRelationsEntity;
import com.illunex.invest.InvestorRelations.persistence.repository.CompanyInfoRepository;
import com.illunex.invest.InvestorRelations.persistence.repository.InvestorRelationsRepository;
import com.illunex.invest.InvestorRelations.service.mapper.CompanyInfoMapper;
import com.illunex.invest.api.core.InvestorRelations.dto.CompanyInfoDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.IRBasicInfoDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvestorRelationsService {
    private Log log = LogFactory.getLog(InvestorRelationsService.class);
    private CompanyInfoMapper companyInfoMapper = Mappers.getMapper(CompanyInfoMapper.class);

    @Autowired InvestorRelationsRepository investorRelationsRepository;
    @Autowired CompanyInfoRepository companyInfoRepository;

    public CompanyInfoDTO editIRBasicInfo(IRBasicInfoDTO irBasicInfoDTO){

        InvestorRelationsEntity investorRelationsEntity = companyInfoMapper.dtoToEntity(irBasicInfoDTO.getInvestorRelationsDTO());
        investorRelationsEntity.setCompanyIdx(2L);
        investorRelationsEntity.setYear("2020");

        Long irIdx = investorRelationsRepository.save(investorRelationsEntity).getIrIdx();

        CompanyInfoEntity companyInfoEntity = companyInfoMapper.dtoToEntity(irBasicInfoDTO.getCompanyInfoDTO());
        companyInfoEntity.setIrIdx(irIdx);
        CompanyInfoEntity result = companyInfoRepository.save(companyInfoEntity);

        return companyInfoMapper.entityToDto(result);
    }
}
