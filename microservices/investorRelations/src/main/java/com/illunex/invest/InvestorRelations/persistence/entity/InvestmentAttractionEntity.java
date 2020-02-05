package com.illunex.invest.InvestorRelations.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "investment_attractsion")
public class InvestmentAttractionEntity {  // 기존 투자 유치
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String name;                    // title
    String price;                   // 금액
}
