package com.illunex.invest.api.core.company.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CompanyProductDTO {
    Long companyProductIdx;
    String title;
    String description;
    String imgUrl;
    String viewMode;
}
