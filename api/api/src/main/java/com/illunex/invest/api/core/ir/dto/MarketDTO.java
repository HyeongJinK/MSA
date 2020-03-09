package com.illunex.invest.api.core.ir.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarketDTO {
    Long idx;
    String area;                    // 지역
    String content;                 // 내용
    String price;                   // 금액
}
