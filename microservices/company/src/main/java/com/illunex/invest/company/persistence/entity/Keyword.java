package com.illunex.invest.company.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "keyword")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Keyword {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
}
