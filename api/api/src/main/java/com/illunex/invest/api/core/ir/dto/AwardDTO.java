package com.illunex.invest.api.core.ir.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AwardDTO {
    Long idx;
    String company;                  // 투자사
    String content;                  // 내용
    String date;                     // 날짜
}
