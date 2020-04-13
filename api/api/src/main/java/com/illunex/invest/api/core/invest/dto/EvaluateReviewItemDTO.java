package com.illunex.invest.api.core.invest.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateReviewItemDTO {
    Long idx;
    String category;
    String content;
    Integer point;
    LocalDateTime updateDate;
}
