package com.illunex.invest.license.entity;

import com.illunex.invest.license.enumable.DealerType;
import com.illunex.invest.license.enumable.ProductType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productIdx;

    @OneToMany
    List<ProductItem> productItems;

    String title;
    String description;
    BigDecimal price;
    ProductType productType;
    DealerType dealerType;
}
