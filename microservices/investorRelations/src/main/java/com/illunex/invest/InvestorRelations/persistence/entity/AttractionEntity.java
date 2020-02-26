package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "investment_attraction")
public class AttractionEntity {  // 기존 투자 유치
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String name;                    // title
    String price;                   // 금액
}
