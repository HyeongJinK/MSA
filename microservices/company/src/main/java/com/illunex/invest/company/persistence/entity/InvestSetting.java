package com.illunex.invest.company.persistence.entity;

import com.illunex.invest.api.core.company.enumable.InvestRoundType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvestSetting {
    @Id @GeneratedValue
    Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    Company company;
    @Embedded
    InvestmentOffer investmentOffer;
    @Embedded
    InvestEvent investEvent;

    InvestRoundType currentRound;
    InvestRoundType progressRound;
    String targetInvestment;
}
