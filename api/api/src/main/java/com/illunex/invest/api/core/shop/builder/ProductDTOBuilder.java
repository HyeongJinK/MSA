package com.illunex.invest.api.core.shop.builder;

import com.illunex.invest.api.core.shop.dto.ProductDTO;
import com.illunex.invest.api.core.shop.enumable.ProductState;
import com.illunex.invest.api.core.shop.enumable.ViewMode;

import java.math.BigDecimal;

public class ProductDTOBuilder {
    private Long id;
    private String title;
    private String description;
    private String imgUrl;
    private BigDecimal price;
    private ViewMode viewMode;

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

    public ProductDTOBuilder imgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public ProductDTOBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductDTOBuilder view(ViewMode viewMode) {
        this.viewMode = viewMode;
        return this;
    }

    public ProductDTO build() {
        return
                new ProductDTO(id, title, description, imgUrl, price, viewMode, false);
    }
}
