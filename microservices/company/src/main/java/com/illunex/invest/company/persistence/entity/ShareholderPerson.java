package com.illunex.invest.company.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "shareholder_person")
public class ShareholderPerson {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String info;
    String personNumber;
    String address;
    String stock;
    String stockValue;
    String totalValue;
    String stake;
}
