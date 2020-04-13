package com.illunex.invest.api.core.investment.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewItemCategoryDTO {
    Long idx;
    String category;

    List<ReviewItemDTO> reviewItem;
}
