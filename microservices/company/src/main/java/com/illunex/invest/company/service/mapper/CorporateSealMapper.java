package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.CompanyIdDTO;
import com.illunex.invest.api.core.company.dto.CorporateSealDTO;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.CorporateSeal;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CorporateSealMapper {
    CorporateSealDTO entityToDto(CorporateSeal signature);
    CorporateSeal dtoToEntity(CorporateSealDTO signatureDTO);

    CompanyIdDTO entityToDto(Company company);
    Company dtoToEntity(CompanyIdDTO companyIdDTO);

    List<CorporateSealDTO> entityToDto(List<CorporateSeal> signature);
    List<CorporateSeal> dtoToEntity(List<CorporateSealDTO> signatureDTO);
}
