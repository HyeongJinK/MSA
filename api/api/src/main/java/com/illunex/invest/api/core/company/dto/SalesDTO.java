package com.illunex.invest.api.core.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesDTO {
    Long id;
    String year;
    String sale;
}
