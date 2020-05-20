package com.illunex.invest.api.core.company.enumable;

import lombok.Getter;

@Getter
public enum InvestRoundType {
    PreSeed("Pre-seed"), Seed("Seed")
    , PreSeries("Pre-series"), SeriesA("Series A")
    , SeriesB(" Series B"), SeriesC("Series C")
    , SeriesD("Series D");

    private final String name;

    InvestRoundType(String name) {
        this.name = name;
    }
}
