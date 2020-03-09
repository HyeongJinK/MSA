package com.illunex.invest.api.core.ir.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShareholderDTO {
    Long idx;
    String name;                // 주주명
    String value;               // 금액
    String etc;                 // 비고
}
