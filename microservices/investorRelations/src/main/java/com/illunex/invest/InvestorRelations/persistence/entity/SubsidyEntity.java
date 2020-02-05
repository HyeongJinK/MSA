package com.illunex.invest.InvestorRelations.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "subsidy")
public class SubsidyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String name;                // title
    String value;               // 금액
}
