package com.illunex.invest.InvestorRelations.service.mapper;

import com.illunex.invest.InvestorRelations.persistence.entity.AttractionEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.IREntity;
import com.illunex.invest.api.core.InvestorRelations.dto.IRDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRMapper {
    IRMapper MAPPER = Mappers.getMapper( IRMapper.class );

    IREntity dtoToEntity(IRDTO IRDTO);
    IRDTO entityToDto(IREntity IREntity);

    List<AttractionEntity> dtoListToEntityList(List<IRDTO> irDtoList);
    List<IRDTO> entityListToDtoList(List<IREntity> investorRelationsEntities);

}
