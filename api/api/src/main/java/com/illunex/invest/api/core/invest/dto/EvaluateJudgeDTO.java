package com.illunex.invest.api.core.invest.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateJudgeDTO {
    Long idx;
    Long userIdx;
    String name;
    String comment;
    String rank;
    String imgUrl;
    String status;

    List<EvaluateReviewItemDTO> reviewItem;
}
