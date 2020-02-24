package com.illunex.invest.InvestorRelations.service.mapper;

import com.illunex.invest.InvestorRelations.persistence.entity.CompanyInfoEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.InvestmentAttractionEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.InvestorRelationsEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.SubsidyEntity;
import com.illunex.invest.api.core.InvestorRelations.dto.CompanyInfoDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.InvestmentAttractionDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.InvestorRelationsDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.SubsidyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyInfoMapper {
    CompanyInfoMapper MAPPER = Mappers.getMapper( CompanyInfoMapper.class );

    InvestorRelationsEntity dtoToEntity(InvestorRelationsDTO investorRelationsDTO);
    InvestorRelationsDTO entityToDto(InvestorRelationsEntity investorRelationsEntity);

    CompanyInfoDTO entityToDto(CompanyInfoEntity companyInfoEntity);
    CompanyInfoEntity dtoToEntity(CompanyInfoDTO companyInfoDTO);

    List<InvestmentAttractionEntity> InvestmentAttractionDtoListToEntity(List<InvestmentAttractionDTO> investmentAttractionDtoLists);
    List<InvestmentAttractionDTO> InvestmentAttractionEntityListToDto(List<InvestorRelationsEntity> investorRelationsEntities);

    List<SubsidyEntity> SubsidyDtoListToEntity(List<SubsidyDTO> subsidyDTOS);
    List<SubsidyDTO> SubsidyEntityListToDto(List<SubsidyEntity> subsidyEntities);

}
