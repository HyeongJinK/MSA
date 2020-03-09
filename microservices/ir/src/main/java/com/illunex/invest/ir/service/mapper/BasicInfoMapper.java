package com.illunex.invest.ir.service.mapper;

import com.illunex.invest.ir.persistence.entity.AttractionEntity;
import com.illunex.invest.ir.persistence.entity.BasicInfoEntity;
import com.illunex.invest.ir.persistence.entity.SubsidyEntity;
import com.illunex.invest.api.core.ir.dto.AttractionDTO;
import com.illunex.invest.api.core.ir.dto.BasicInfoDTO;
import com.illunex.invest.api.core.ir.dto.SubsidyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BasicInfoMapper {
    BasicInfoMapper MAPPER = Mappers.getMapper( BasicInfoMapper.class );

    BasicInfoDTO entityToDto(BasicInfoEntity basicInfoEntity);
    BasicInfoEntity dtoToEntity(BasicInfoDTO basicInfoDTO);

    List<AttractionEntity> attractionDtoListToEntity(List<AttractionDTO> attractionDtoLists);
    List<AttractionDTO> attractionEntityListToDto(List<AttractionEntity> attractionEntities);

    List<SubsidyEntity> SubsidyDtoListToEntity(List<SubsidyDTO> subsidyDTOS);
    List<SubsidyDTO> SubsidyEntityListToDto(List<SubsidyEntity> subsidyEntities);

}
