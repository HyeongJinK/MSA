package com.illunex.invest.api.core.invest.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JudgeDTO {
    Long idx;
    Long userIdx;
    String name;
    String rank;
    String imgUrl;
    String comment;
    String status;
    Integer point;
}
