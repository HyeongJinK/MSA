package com.illunex.invest.investorRelations.entity;

import javax.persistence.*;

@Entity
public class Subsidy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String name;                // title
    String value;               // 금액
}
