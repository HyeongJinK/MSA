package com.illunex.invest.api.core.investment.dto;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VQAnswerDTO {
    List<CompanyDTO> companyList;
    List<VQRoundDTO> answerList;
}
