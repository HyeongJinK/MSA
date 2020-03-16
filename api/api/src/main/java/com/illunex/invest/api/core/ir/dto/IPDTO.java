package com.illunex.invest.api.core.ir.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IPDTO {
    Long idx;
    String area;                         // 선택
    String applicationNumber;            // 출원번호
    String content;                      // 내용
    String date;                         // 날짜
}
