package com.illunex.invest.api.core.company.dto;

import com.illunex.invest.api.composite.startup.company.dto.CompanyInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    Long companyMemberIdx;
    String name;
    String rank;
    String career;
    String imgUrl;

    CompanyInfoDTO companyDTO;
}
