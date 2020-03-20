package com.illunex.invest.api.core.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDetailDTO {
    Long id;
    ProductDTO product;
    int count;
}
