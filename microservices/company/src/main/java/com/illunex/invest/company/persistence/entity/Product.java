package com.illunex.invest.company.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "product")
@Getter @Setter
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;           // 제품명
    String description;     // 제품 설명
    String viewMode;        // 공개 여부
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    List<ProductImage> productImages = new ArrayList<>();   // 제품 이미지

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    List<Keyword> keywords = new ArrayList<>();
}
