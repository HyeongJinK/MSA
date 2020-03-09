package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.*;
import com.illunex.invest.company.persistence.entity.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDTO entityToDto(Company company);
    Company dtoToEntity(CompanyDTO companyDTO);

    List<MainProductLineDTO> mainProductLineEntityListToDtoList(List<MainProductLine> mainProductLines);
    List<MainProductLine> producmainProductLineDtoListToEntityList(List<MainProductLineDTO> mainProductLines);

    List<ProductDTO> productEntityListToDtoList(List<Product> productEntities);
    List<Product> productDtoListToEntityList(List<ProductDTO> companyProducts);

    List<MemberDTO> memberEntityListToDtoList(List<Member> memberEntities);
    List<Member> memberDtoListToEntityList(List<MemberDTO> companyMembers);
}

