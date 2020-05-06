package com.illunex.invest.api.core.company.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VcProductDTO {
    Long id;
    String title;
    String description;
    LocalDateTime regDate;
    Boolean representation;
    List<ProductImageDTO> productImages = new ArrayList<>();
    List<KeywordDTO> keywords = new ArrayList<>();
}
