package com.illunex.invest.api.core.invest.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewItemDTO {
    Long idx;
    Long vcCompanyIdx;
    String category;
    String content;
    LocalDateTime updateDate;
    Integer point;
    Boolean deleted;
}
