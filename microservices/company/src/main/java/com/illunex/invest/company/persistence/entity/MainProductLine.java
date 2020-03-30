package com.illunex.invest.company.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "main_product_line")
@Getter @Setter
@NoArgsConstructor
public class MainProductLine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;

    public MainProductLine(String title) {
        this.title = title;
    }
}
