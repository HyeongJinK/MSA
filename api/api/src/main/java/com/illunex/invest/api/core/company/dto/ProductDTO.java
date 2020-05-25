package com.illunex.invest.api.core.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    LocalDateTime regDate;
    List<ProductImageDTO> productImages = new ArrayList<>();
    List<KeywordDTO> keywords = new ArrayList<>();
    CompanyDTO company;

    public String getParseRegDate() {
        if (regDate != null) {
            return regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else {
            return "";
        }
    }
}
