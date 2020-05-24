package com.illunex.invest.company.persistence.entity;

import com.illunex.invest.api.core.company.enumable.InvestRoundType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
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

    @Enumerated(value = EnumType.STRING)
    InvestRoundType currentRound;
    @Enumerated(value = EnumType.STRING)
    InvestRoundType progressRound;
    String targetInvestment;
}
