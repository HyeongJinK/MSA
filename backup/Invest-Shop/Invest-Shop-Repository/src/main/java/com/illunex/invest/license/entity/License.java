package com.illunex.invest.license.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long licenseIdx;
    String title;
    BigDecimal price;
}
