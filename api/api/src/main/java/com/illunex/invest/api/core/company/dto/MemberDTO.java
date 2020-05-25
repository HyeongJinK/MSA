package com.illunex.invest.api.core.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    Long companyMemberIdx;
    String dept;
    String name;
    String rank;
    String career;
    String imgUrl;

    CompanyIdDTO company;
}
