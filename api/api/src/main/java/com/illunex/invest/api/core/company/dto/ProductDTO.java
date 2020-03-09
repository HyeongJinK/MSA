package com.illunex.invest.api.core.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    Long id;
    String title;
    String description;
    String viewMode;

    List<ProductImageDTO> productImages = new ArrayList<>();
    List<KeywordDTO> keywords = new ArrayList<>();
    CompanyDTO company;
}
