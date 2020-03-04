package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "award")
public class AwardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String company;                  // 투자사
    String content;                  // 내용
    String date;                     // 날짜

    @ManyToOne
    @JoinColumn(name = "outcome_idx")
    OutcomeEntity outcome;
}
