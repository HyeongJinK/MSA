package com.illunex.invest.investment.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "judge")
public class Judge {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    Long companyIdx;
    Long userIdx;
    String name;
    String rank;
    String company;
    String imgUrl;
    String comment;
    String status;
    Integer point;
}
