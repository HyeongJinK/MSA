package com.illunex.invest.InvestorRelations.service.mapper;

import com.illunex.invest.InvestorRelations.persistence.entity.AttractionEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.BasicInfoEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.IREntity;
import com.illunex.invest.InvestorRelations.persistence.entity.SubsidyEntity;
import com.illunex.invest.api.core.InvestorRelations.dto.AttractionDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.BasicInfoDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.SubsidyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BasicInfoMapper {
    BasicInfoMapper MAPPER = Mappers.getMapper( BasicInfoMapper.class );

    BasicInfoDTO entityToDto(BasicInfoEntity basicInfoEntity);
    BasicInfoEntity dtoToEntity(BasicInfoDTO basicInfoDTO);

    //IRDTO entityToDto(IREntity irEntity);


    List<AttractionEntity> InvestmentAttractionDtoListToEntity(List<AttractionDTO> attractionDtoLists);
    List<AttractionDTO> InvestmentAttractionEntityListToDto(List<IREntity> investorRelationsEntities);

    List<SubsidyEntity> SubsidyDtoListToEntity(List<SubsidyDTO> subsidyDTOS);
    List<SubsidyDTO> SubsidyEntityListToDto(List<SubsidyEntity> subsidyEntities);

}
