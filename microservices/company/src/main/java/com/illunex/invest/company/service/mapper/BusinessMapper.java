package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.BusinessDTO;
import com.illunex.invest.company.persistence.entity.Business;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessMapper {
    BusinessDTO entityToDto(Business business);
    Business dtoToEntity(BusinessDTO businessDTO);
}
