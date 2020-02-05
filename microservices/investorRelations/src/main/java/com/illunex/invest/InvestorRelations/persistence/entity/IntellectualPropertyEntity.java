package com.illunex.invest.InvestorRelations.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "intellectual_property")
public class IntellectualPropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String number;
    String description;
    String date;
}
