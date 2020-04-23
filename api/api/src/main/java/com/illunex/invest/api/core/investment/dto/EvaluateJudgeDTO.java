package com.illunex.invest.api.core.investment.dto;

import lombok.*;

import java.time.LocalDateTime;
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
    Integer score;
    LocalDateTime evaluateDate;

    List<EvaluateReviewItemCategoryDTO> reviewItemCategory;
}
