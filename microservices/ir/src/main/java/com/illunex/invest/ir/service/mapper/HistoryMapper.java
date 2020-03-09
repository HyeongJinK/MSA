package com.illunex.invest.ir.service.mapper;

import com.illunex.invest.ir.persistence.entity.AttractionEntity;
import com.illunex.invest.ir.persistence.entity.BasicInfoEntity;
import com.illunex.invest.ir.persistence.entity.HistoryEntity;
import com.illunex.invest.ir.persistence.entity.SubsidyEntity;
import com.illunex.invest.api.core.ir.dto.AttractionDTO;
import com.illunex.invest.api.core.ir.dto.BasicInfoDTO;
import com.illunex.invest.api.core.ir.dto.HistoryDTO;
import com.illunex.invest.api.core.ir.dto.SubsidyDTO;
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
