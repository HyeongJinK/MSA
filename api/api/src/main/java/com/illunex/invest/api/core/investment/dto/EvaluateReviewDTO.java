package com.illunex.invest.api.core.investment.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateReviewDTO {
    Long idx;
    String content;
    EvaluateJudgeDTO judge;
}
