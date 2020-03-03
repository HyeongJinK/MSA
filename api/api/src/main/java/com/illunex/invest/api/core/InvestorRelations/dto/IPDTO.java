package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IPDTO {
    Long idx;
    String applicationNumber;            // 출원번호
    String content;                      // 내용
    LocalDateTime date;                  // 날짜
}
