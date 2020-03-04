package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plan")
public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String indicator;              // 주요지표
    String now;                    // 현재
    String threeMonth;             // +3M
    String sixMonth;               // +6M
    String twelveMonth;            // +12M

    @ManyToOne
    @JoinColumn(name = "outcome_idx")
    OutcomeEntity outcome;
}
