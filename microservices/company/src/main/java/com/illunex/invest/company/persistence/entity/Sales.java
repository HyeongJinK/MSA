package com.illunex.invest.company.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sales {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String year;
    String sale;
}
