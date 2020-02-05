package com.illunex.invest.InvestorRelations.service.mapper;

import com.illunex.invest.InvestorRelations.persistence.entity.InvestorRelationsEntity;
import com.illunex.invest.api.core.InvestorRelations.dto.InvestorRelations;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvestorRelationsMapper {
    InvestorRelations entityToDto(InvestorRelationsEntity investorRelationsEntity);
    InvestorRelationsEntity dtoToEntity(InvestorRelations investorRelations);

    List<InvestorRelations> entityListToDtoList(List<InvestorRelationsEntity> investorRelationsEntities);
    List<InvestorRelationsEntity> dtoListToEntityList(List<InvestorRelations> investorRelations);
}
