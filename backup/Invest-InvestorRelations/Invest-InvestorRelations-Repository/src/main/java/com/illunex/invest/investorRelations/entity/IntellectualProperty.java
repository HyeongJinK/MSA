package com.illunex.invest.investorRelations.entity;

import javax.persistence.*;

@Entity
public class IntellectualProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String number;
    String description;
    String date;
}
