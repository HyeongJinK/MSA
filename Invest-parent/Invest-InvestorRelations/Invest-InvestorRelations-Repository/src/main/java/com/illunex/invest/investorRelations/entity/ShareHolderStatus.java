package com.illunex.invest.investorRelations.entity;

import javax.persistence.*;

@Entity
public class ShareHolderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String name;                // 주주명
    String value;               // 금액
    String equityRatio;         // 지분율
    String etc;                 // 비고
}
