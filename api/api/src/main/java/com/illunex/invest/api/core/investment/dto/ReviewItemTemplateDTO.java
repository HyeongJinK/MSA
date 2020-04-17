package com.illunex.invest.api.core.investment.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewItemTemplateDTO {
    Long idx;
    Long companyIdx;
    String title;
    LocalDateTime updateDate;
    Integer point;
    Boolean deleted;
    Boolean weight;

    List<ReviewItemCategoryDTO> reviewItemCategory;
}
