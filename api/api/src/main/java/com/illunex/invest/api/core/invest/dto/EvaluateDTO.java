package com.illunex.invest.api.core.invest.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateDTO {
    Long idx;
    Long companyIdx;
    String product;
    String company;
    String imgUrl;
    String updateDate;
    String scale;
    String status;
    Integer score;

    List<JudgeDTO> judgeList;
    List<ReviewItemDTO> reviewItemList;
}
