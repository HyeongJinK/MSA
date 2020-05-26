package com.illunex.invest.ir.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    @Column(length=2000)
    String productInformation;           // 제품 설명
    @Column(length=2000)
    String productDifference;            // 제품 차별성
    @Column(length=2000)
    String mainTechnology;               // 주요 기술
    @Column(length=2000)
    String technologyDifference;         // 기술 차별성
    @Column(length=2000)
    String marketResearch;               // 시장 리서치
    @Column(length=2000)
    String positioning;                  // 포지셔닝

    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    IREntity ir;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<CustomerEntity> customer;           // 주요 매출처

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<IPEntity> ip;                       // 지적 재산권

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<MarketEntity> market;               // 목표 시장

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<MarketPlayerEntity> marketPlayer;   // 주요 경쟁사

}
