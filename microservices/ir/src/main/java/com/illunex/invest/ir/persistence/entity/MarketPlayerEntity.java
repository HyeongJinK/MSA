package com.illunex.invest.ir.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "market_player")
public class MarketPlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String area;                // 지역
    String name;                // 기업명
    String content;             // 내용
    String sales;               // 매출

    @ManyToOne
    @JoinColumn(name = "product_idx")
    ProductEntity product;
}
