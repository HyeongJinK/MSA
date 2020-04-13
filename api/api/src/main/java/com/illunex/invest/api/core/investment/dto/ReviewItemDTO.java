package com.illunex.invest.api.core.investment.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewItemDTO {
    Long idx;
    String content;
    Integer point;
}
