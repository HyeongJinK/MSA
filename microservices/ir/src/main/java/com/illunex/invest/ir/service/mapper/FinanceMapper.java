package com.illunex.invest.ir.service.mapper;

import com.illunex.invest.ir.persistence.entity.*;
import com.illunex.invest.api.core.ir.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FinanceMapper {
    FinanceMapper MAPPER = Mappers.getMapper( FinanceMapper.class );

    FinanceDTO entityToDto(FinanceEntity financeEntity);
    FinanceEntity dtoToEntity(FinanceDTO financeDTO);

    List<FinancialStatusEntity> financialStatusDtoListToEntity(List<FinancialStatusDTO> financialStatusDTOS);
    List<FinancialStatusDTO> financialStatusEntityListToDto(List<FinancialStatusEntity> financialStatusEntities);

}
