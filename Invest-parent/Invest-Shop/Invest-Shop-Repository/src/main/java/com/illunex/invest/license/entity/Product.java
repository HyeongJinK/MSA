package com.illunex.invest.license.entity;

import javax.persistence.*;
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
}
