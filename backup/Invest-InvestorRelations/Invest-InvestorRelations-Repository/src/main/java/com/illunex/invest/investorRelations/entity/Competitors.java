package com.illunex.invest.investorRelations.entity;

import com.illunex.invest.investorRelations.entity.enumable.NationType;

import javax.persistence.*;

@Entity
public class Competitors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long competitorsIdx;
    @Enumerated(EnumType.STRING)
    NationType nation;          // 국가
    String description;         // 내용
    String sales;               // 매출
}
