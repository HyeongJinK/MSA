package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.CompanyIdDTO;
import com.illunex.invest.api.core.company.dto.MemberDTO;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberDTO entityToDto(Member Member);
    Member dtoToEntity(MemberDTO MemberDTO);

    List<MemberDTO> entityToDto(List<Member> members);
    List<Member> dtoToEntity(List<MemberDTO> memberDTOS);

    CompanyIdDTO companyEntityToDto(Company company);
    Company companyDtoToEntity(CompanyIdDTO companyDTO);
}
