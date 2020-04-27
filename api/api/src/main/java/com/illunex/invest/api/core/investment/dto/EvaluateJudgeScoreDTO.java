package com.illunex.invest.api.core.investment.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateJudgeScoreDTO {
    Long idx;
    Long categoryIdx;
    Long reviewItemIdx;
    Integer score;
}
