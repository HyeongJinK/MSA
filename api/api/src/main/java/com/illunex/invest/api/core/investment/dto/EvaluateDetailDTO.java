package com.illunex.invest.api.core.investment.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateDetailDTO {
    EvaluateDTO evaluate;
    JudgeDTO judge;
}
