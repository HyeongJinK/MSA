package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IRBasicInfoDTO { // IR 기본작성 페이지
    InvestorRelationsDTO investorRelationsDTO;
    CompanyInfoDTO companyInfoDTO;
}
