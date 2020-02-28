package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShareholderDTO {
    Long idx;
    Long irIdx;
    String name;                // 주주명
    String value;               // 금액
    String etc;                 // 비고
}
