package com.illunex.invest.ir.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fund")
public class FundEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String content;                  // 내용
    String value;                    // 금액
    String date;                     // 날짜

    @ManyToOne
    @JoinColumn(name = "outcome_idx")
    OutcomeEntity outcome;
}
