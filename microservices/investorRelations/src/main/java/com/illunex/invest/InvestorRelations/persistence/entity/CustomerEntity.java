package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class CustomerEntity {  // 주요 매출처
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String content;                 // 내용
    String price;                   // 금액

    @ManyToOne
    @JoinColumn(name = "product_idx")
    ProductEntity product;
}
