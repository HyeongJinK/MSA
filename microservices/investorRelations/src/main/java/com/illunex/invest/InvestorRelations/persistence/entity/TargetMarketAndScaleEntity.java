package com.illunex.invest.InvestorRelations.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "target_market_and_scale")
public class TargetMarketAndScaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
}
