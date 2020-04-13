package com.illunex.invest.api.core.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ShareholderPersonDTO {
    Long id;
    String info;
    String personNumber;
    String address;
    String stock;
    String stockValue;
    String totalValue;
    String stake;
}
