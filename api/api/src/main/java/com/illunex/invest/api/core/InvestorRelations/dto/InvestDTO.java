package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvestDTO {
    Long idx;
    String company;                  // 투자사
    String value;                    // 금액
    String date;                     // 날짜
}
