package com.illunex.invest.investorRelations.entity;

import javax.persistence.*;

@Entity
public class InvestmentAttraction {  // 기존 투자 유치
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String name;                    // title
    String price;                   // 금액
}
