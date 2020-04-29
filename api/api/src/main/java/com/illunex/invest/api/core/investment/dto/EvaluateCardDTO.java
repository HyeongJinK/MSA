package com.illunex.invest.api.core.investment.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateCardDTO {
    Long idx;
    Long companyIdx;
    Long vcCompanyIdx;
    String product;
    String company;
    String imgUrl;
    LocalDateTime createDate;
    LocalDateTime requestDate;
    LocalDateTime completeDate;
    String scale;
    String status;

    List<EvaluateCardJudgeDTO> judgeList;
}
