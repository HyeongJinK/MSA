package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasicInfoDTO { // IR 기본작성 페이지
    InvestorRelationsDTO investorRelationsDTO;
    CompanyInfoDTO companyInfoDTO;
}
