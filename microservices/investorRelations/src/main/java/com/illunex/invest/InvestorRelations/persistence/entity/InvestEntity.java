package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invest")
public class InvestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String company;                  // 투자사
    String value;                    // 금액
    String date;                     // 날짜

    @ManyToOne
    @JoinColumn(name = "outcome_idx")
    OutcomeEntity outcome;
}
