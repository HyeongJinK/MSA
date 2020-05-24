package com.illunex.invest.api.core.company.dto;

import com.illunex.invest.api.core.company.enumable.InvestRoundType;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"investmentOffer", "investEvent", "currentRound", "progressRound", "targetInvestment"})
public class InvestSettingDTO {
    Long id;
    CompanyIdDTO company;
    InvestmentOfferDTO investmentOffer;
    InvestEventDTO investEvent;
    InvestRoundType currentRound;
    InvestRoundType progressRound;
    String targetInvestment;

    public void setCompany(CompanyIdDTO company) {
        this.company = company;
    }
}
