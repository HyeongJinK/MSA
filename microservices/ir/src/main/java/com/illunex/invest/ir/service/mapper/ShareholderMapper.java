package com.illunex.invest.ir.service.mapper;

import com.illunex.invest.ir.persistence.entity.HistoryEntity;
import com.illunex.invest.ir.persistence.entity.ShareholderEntity;
import com.illunex.invest.api.core.ir.dto.HistoryDTO;
import com.illunex.invest.api.core.ir.dto.ShareholderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShareholderMapper {
    ShareholderMapper MAPPER = Mappers.getMapper( ShareholderMapper.class );

    ShareholderDTO entityToDto(ShareholderEntity shareholderEntity);
    ShareholderEntity dtoToEntity(ShareholderDTO shareholderDTO);

    List<ShareholderEntity> shareholderDtoListToEntity(List<ShareholderDTO> shareholderDTOS);
    List<ShareholderDTO> shareholderEntityListToDto(List<ShareholderEntity> shareholderEntities);

}
