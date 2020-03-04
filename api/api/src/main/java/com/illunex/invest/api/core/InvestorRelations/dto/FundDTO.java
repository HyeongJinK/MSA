package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FundDTO {
    Long idx;
    String content;                  // 내용
    String value;                    // 금액
    String date;                     // 날짜
}
