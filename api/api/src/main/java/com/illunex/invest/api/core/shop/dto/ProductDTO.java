package com.illunex.invest.api.core.shop.dto;

import com.illunex.invest.api.core.shop.enumable.ProductState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductDTO {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private ProductState productState;
}
