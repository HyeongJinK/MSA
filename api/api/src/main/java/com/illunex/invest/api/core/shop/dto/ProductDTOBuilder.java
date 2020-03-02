package com.illunex.invest.api.core.shop.dto;

import com.illunex.invest.api.core.shop.enumable.ProductState;

import java.math.BigDecimal;

public class ProductDTOBuilder {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private ProductState productState;

    public static ProductDTOBuilder builder() {
        return new ProductDTOBuilder();
    }

    public ProductDTOBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ProductDTOBuilder title(String title) {
        this.title = title;
        return this;
    }

    public ProductDTOBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProductDTOBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductDTOBuilder productState(ProductState productState) {
        this.productState = productState;
        return this;
    }

    public ProductDTO build() {
        return new ProductDTO(id, title, description, price, productState);
    }
}
