package com.illunex.invest.company.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "main_product_line")
@Getter @Setter
public class MainProductLine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
}
