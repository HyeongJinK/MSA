package com.illunex.invest.api.core.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VcProductDTO {
    Long id;
    String title;
    String description;
    LocalDateTime regDate;
    Boolean representation;
    List<ProductImageDTO> productImages = new ArrayList<>();
    List<KeywordDTO> keywords = new ArrayList<>();
}
