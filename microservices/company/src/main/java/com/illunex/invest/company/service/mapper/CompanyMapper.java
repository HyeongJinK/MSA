package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.CompanyMemberDTO;
import com.illunex.invest.api.core.company.dto.CompanyProductDTO;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.CompanyMember;
import com.illunex.invest.company.persistence.entity.CompanyProduct;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDTO entityToDto(Company company);
    Company dtoToEntity(CompanyDTO companyDTO);

    List<CompanyProductDTO> productEntityListToDtoList(List<CompanyProduct> companyProductEntities);
    List<CompanyProduct> productDtoListToEntityList(List<CompanyProductDTO> companyProductDTOS);

    List<CompanyMemberDTO> memberEntityListToDtoList(List<CompanyMember> companyMemberEntities);
    List<CompanyMember> memberDtoListToEntityList(List<CompanyMemberDTO> companyMemberDTOS);
}

