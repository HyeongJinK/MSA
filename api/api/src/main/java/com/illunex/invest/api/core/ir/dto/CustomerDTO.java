package com.illunex.invest.api.core.ir.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    Long idx;
    String area;                    // 선택
    String content;                 // 내용
    String price;                   // 금액
}
