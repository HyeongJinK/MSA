package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.CompanyMemberDTO;
import com.illunex.invest.api.core.company.dto.CompanyProductDTO;
import com.illunex.invest.company.persistence.entity.CompanyEntity;
import com.illunex.invest.company.persistence.entity.CompanyMemberEntity;
import com.illunex.invest.company.persistence.entity.CompanyProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDTO entryToDto(CompanyEntity companyEntity);
    CompanyEntity dtoToEntity(CompanyDTO companyDTO);

    List<CompanyProductDTO> productEntityListToDtoList(List<CompanyProductEntity> companyProductEntities);
    List<CompanyProductEntity> productDtoListToEntityList(List<CompanyProductDTO> companyProductDTOS);

    List<CompanyMemberDTO> memberEntityListToDtoList(List<CompanyMemberEntity> companyMemberEntities);
    List<CompanyMemberEntity> memberDtoListToEntityList(List<CompanyMemberDTO> companyMemberDTOS);
}

