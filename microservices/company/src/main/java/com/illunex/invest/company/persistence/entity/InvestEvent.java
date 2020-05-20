package com.illunex.invest.company.persistence.entity;

import javax.persistence.Embeddable;

@Embeddable
public class InvestEvent {
    boolean vc;
    boolean agency;
}
