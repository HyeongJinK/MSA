package com.illunex.invest.InvestorRelations.service.mapper;

import com.illunex.invest.InvestorRelations.persistence.entity.InvestorRelationsEntity;
import com.illunex.invest.api.core.InvestorRelations.dto.InvestorRelations;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvestorRelationsMapper {
    InvestorRelationsDTO entityToDto(InvestorRelationsEntity investorRelationsEntity);
    InvestorRelationsEntity dtoToEntity(InvestorRelationsDTO investorRelationsDTO);

    List<InvestorRelationsDTO> entityListToDtoList(List<InvestorRelationsEntity> investorRelationsEntities);
    List<InvestorRelationsEntity> dtoListToEntityList(List<InvestorRelationsDTO> investorRelations);
}
