package com.illunex.invest.api.core.investment.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateDTO {
    Long idx;
    Long companyIdx;
    Long vcCompanyIdx;
    String product;
    String company;
    String imgUrl;
    LocalDateTime createDate;
    LocalDateTime requestDate;
    LocalDateTime completeDate;
    LocalDateTime startupConfirmDate;
    String scale;
    String status;
    String content;
    Integer averageScore;

    EvaluateReviewItemTemplateDTO template;
    List<EvaluateJudgeDTO> judgeList;
}
