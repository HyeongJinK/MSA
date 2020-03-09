package com.illunex.invest.api.core.ir.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanDTO {
    Long idx;
    String indicator;              // 주요지표
    String now;                    // 현재
    String threeMonth;             // +3M
    String sixMonth;               // +6M
    String twelveMonth;            // +12M
}
