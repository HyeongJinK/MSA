package com.illunex.invest.company.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "shareholder_person")
public class ShareholderPerson {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String info;
    String address;
    String stock;
    String stockValue;
    String totalValue;
    String stake;
}
