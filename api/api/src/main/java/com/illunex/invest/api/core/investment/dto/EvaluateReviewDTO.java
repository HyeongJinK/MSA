package com.illunex.invest.api.core.investment.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateReviewDTO {
    Long idx;
    Long companyIdx;
    Long vcCompanyIdx;
    String content;

    EvaluateJudgeDTO judge;
}
