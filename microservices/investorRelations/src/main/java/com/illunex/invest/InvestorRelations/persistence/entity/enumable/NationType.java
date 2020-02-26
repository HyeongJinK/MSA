package com.illunex.invest.InvestorRelations.persistence.entity.enumable;

public enum NationType {
    Domestic("국내"),
    Abroad("해외");
    private String value;

    public String getValue() {
        return value;
    }

    NationType(String des) {
        this.value = des;
    }
}
