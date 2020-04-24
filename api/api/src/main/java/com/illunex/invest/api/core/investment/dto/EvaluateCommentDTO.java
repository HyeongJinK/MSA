package com.illunex.invest.api.core.investment.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateCommentDTO {
    Long evaluateIdx;
    Long userIdx;
    String comment;
}
