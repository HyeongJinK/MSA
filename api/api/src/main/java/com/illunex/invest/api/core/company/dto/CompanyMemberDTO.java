package com.illunex.invest.api.core.company.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CompanyMemberDTO {
    Long companyMemberIdx;
    String name;
    String rank;
    String career;
    String imgUrl;
}
