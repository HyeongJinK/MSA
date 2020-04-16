package com.illunex.invest.api.core.investment.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JudgeDTO {
    Long idx;
    Long companyIdx;
    Long userIdx;
    String name;
    String rank;
    String company;
    String imgUrl;
    String comment;
    String status;
    Integer point;
}
