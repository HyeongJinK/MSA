package com.illunex.invest.api.core.invest.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewItemDTO {
    Long idx;
    String category;
    String title;
    Integer point;
    String content;
    String updateDate;
    Boolean deleted;
}
