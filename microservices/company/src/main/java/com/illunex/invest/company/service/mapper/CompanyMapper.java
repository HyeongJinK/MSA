package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.MemberDTO;
import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.api.core.company.dto.MainProductLineDTO;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.Member;
import com.illunex.invest.company.persistence.entity.Product;
import com.illunex.invest.company.persistence.entity.MainProductLine;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDTO entityToDto(Company company);
    Company dtoToEntity(CompanyDTO companyDTO);

    List<MainProductLineDTO> mainProductLineEntityListToDtoList(List<MainProductLine> companyProductEntities);
    List<MainProductLine> producmainProductLineDtoListToEntityList(List<MainProductLineDTO> companyProductDTOS);

    List<ProductDTO> productEntityListToDtoList(List<Product> productEntities);
    List<Product> productDtoListToEntityList(List<ProductDTO> productDTOS);

    List<MemberDTO> memberEntityListToDtoList(List<Member> memberEntities);
    List<Member> memberDtoListToEntityList(List<MemberDTO> memberDTOS);
}

