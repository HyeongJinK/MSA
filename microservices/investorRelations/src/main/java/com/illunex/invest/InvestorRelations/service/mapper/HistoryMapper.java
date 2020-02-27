package com.illunex.invest.InvestorRelations.service.mapper;

import com.illunex.invest.InvestorRelations.persistence.entity.AttractionEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.BasicInfoEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.HistoryEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.SubsidyEntity;
import com.illunex.invest.api.core.InvestorRelations.dto.AttractionDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.BasicInfoDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.HistoryDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.SubsidyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistoryMapper {
    HistoryMapper MAPPER = Mappers.getMapper( HistoryMapper.class );

    HistoryDTO entityToDto(HistoryEntity historyEntity);
    HistoryEntity dtoToEntity(HistoryDTO historyDTO);

    List<HistoryEntity> historyDtoListToEntity(List<HistoryDTO> historyDTOS);
    List<HistoryDTO> historyEntityListToDto(List<HistoryEntity> historyEntities);

}
