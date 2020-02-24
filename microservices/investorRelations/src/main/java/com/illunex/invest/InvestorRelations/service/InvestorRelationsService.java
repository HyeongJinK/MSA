package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.entity.CompanyInfoEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.InvestorRelationsEntity;
import com.illunex.invest.InvestorRelations.persistence.repository.CompanyInfoRepository;
import com.illunex.invest.InvestorRelations.persistence.repository.InvestorRelationsRepository;
import com.illunex.invest.InvestorRelations.service.mapper.CompanyInfoMapper;
import com.illunex.invest.api.core.InvestorRelations.dto.CompanyInfoDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.IRBasicInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvestorRelationsService {
    Logger logger = LoggerFactory.getLogger(InvestorRelationsService.class);
    @Autowired InvestorRelationsRepository investorRelationsRepository;
    @Autowired CompanyInfoRepository companyInfoRepository;

    public CompanyInfoDTO editIRBasicInfo(IRBasicInfoDTO irBasicInfoDTO){
        System.out.println("----investorRelations dto"+irBasicInfoDTO.getInvestorRelationsDTO());
        System.out.println("----companyInfo dto"+irBasicInfoDTO.getCompanyInfoDTO().getAddress());
        System.out.println("----companyInfo dto subsidy"+irBasicInfoDTO.getCompanyInfoDTO().getSubsidy());
        System.out.println("----companyInfo dto investmentAttraction"+irBasicInfoDTO.getCompanyInfoDTO().getInvestmentAttraction());

        System.out.println("---ir save---");
        InvestorRelationsEntity investorRelationsEntity = CompanyInfoMapper.MAPPER.dtoToEntity(irBasicInfoDTO.getInvestorRelationsDTO());
        investorRelationsEntity.setCompanyIdx(2L);
        investorRelationsEntity.setYear("2020");
        Long irIdx = investorRelationsRepository.save(investorRelationsEntity).getIrIdx();
        System.out.println("---new ir idx---"+irIdx);

        System.out.println("---company_info save---");
        CompanyInfoEntity companyInfoEntity = CompanyInfoMapper.MAPPER.dtoToEntity(irBasicInfoDTO.getCompanyInfoDTO());
        System.out.println("---ia---"+companyInfoEntity.getInvestmentAttraction());
        System.out.println(companyInfoEntity.getInvestmentAttraction().get(0));
        System.out.println(companyInfoEntity.getInvestmentAttraction().get(1));
        System.out.println("---subsidy---"+companyInfoEntity.getSubsidy());
        System.out.println(companyInfoEntity.getSubsidy().get(0));
        System.out.println(companyInfoEntity.getSubsidy().get(1));

        logger.debug(companyInfoEntity.getSubsidy().get(1).toString());

        companyInfoEntity.setIrIdx(irIdx);

        companyInfoRepository.save(companyInfoEntity);

        System.out.println("---new company_info idx---"+companyInfoEntity.getCiIdx());



        return irBasicInfoDTO.getCompanyInfoDTO();
    }

}
