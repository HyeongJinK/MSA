package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarketPlayerDTO {
    Long idx;
    String area;                // 지역
    String name;                // 기업명
    String content;             // 내용
    String sales;               // 매출
}
