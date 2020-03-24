package com.illunex.invest.api.core.shop.dto;

import com.illunex.invest.api.core.shop.enumable.ViewMode;
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
    private String imgUrl;
    private BigDecimal price;
    private ViewMode viewMode;
    private boolean installed = false;

    public void setInstalled(boolean installed) {
        this.installed = installed;
    }
}
