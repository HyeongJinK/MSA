package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.BusinessDTO;
import com.illunex.invest.api.core.company.dto.CompanyIdDTO;
import com.illunex.invest.company.persistence.entity.Business;
import com.illunex.invest.company.persistence.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessMapper {
    BusinessDTO entityToDto(Business business);
    Business dtoToEntity(BusinessDTO businessDTO);

    CompanyIdDTO entityToDto(Company company);
    Company dtoToEntity(CompanyIdDTO companyIdDTO);
}
