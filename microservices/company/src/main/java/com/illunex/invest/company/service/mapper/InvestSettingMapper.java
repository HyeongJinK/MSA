package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.CompanyIdDTO;
import com.illunex.invest.api.core.company.dto.InvestEventDTO;
import com.illunex.invest.api.core.company.dto.InvestSettingDTO;
import com.illunex.invest.api.core.company.dto.InvestmentOfferDTO;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.InvestEvent;
import com.illunex.invest.company.persistence.entity.InvestSetting;
import com.illunex.invest.company.persistence.entity.InvestmentOffer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvestSettingMapper {
    InvestSettingDTO entityToDto(InvestSetting investSetting);
    InvestSetting dtoToEntity(InvestSettingDTO investSettingDTO);

    InvestmentOfferDTO entityToDto(InvestmentOffer investSetting);
    InvestmentOffer dtoToEntity(InvestmentOfferDTO investSettingDTO);

    InvestEventDTO entityToDto(InvestEvent investSetting);
    InvestEvent dtoToEntity(InvestEventDTO investSettingDTO);

    CompanyIdDTO entityToDto(Company company);
    Company dtoToEntity(CompanyIdDTO companyIdDTO);
}
