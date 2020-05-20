package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.CompanyIdDTO;
import com.illunex.invest.api.core.company.dto.InvestSettingDTO;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.InvestSetting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvestSettingMapper {
    InvestSettingDTO entityToDto(InvestSetting investSetting);
    InvestSetting dtoToEntity(InvestSettingDTO investSettingDTO);

    CompanyIdDTO entityToDto(Company company);
    Company dtoToEntity(CompanyIdDTO companyIdDTO);
}
