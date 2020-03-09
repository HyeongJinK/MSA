package com.illunex.invest.company.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String imgUrl;
}
