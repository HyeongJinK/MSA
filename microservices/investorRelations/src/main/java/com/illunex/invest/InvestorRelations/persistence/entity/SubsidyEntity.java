package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "subsidy")
public class SubsidyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String name;                // title
    String value;               // 금액
}
