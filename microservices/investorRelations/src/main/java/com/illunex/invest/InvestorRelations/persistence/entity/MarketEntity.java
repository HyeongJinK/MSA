package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "market")
public class MarketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String area;                    // 지역
    String content;                 // 내용
    String price;                   // 금액

    @ManyToOne
    @JoinColumn(name = "product_idx")
    ProductEntity product;
}
