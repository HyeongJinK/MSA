package com.illunex.invest.InvestorRelations.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "financial_status")
public class FinancialStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long financialStatusIdx;
    String borrower;                // 차입처
    String borrowingAmount;         // 차입금액
    String expiryDate;              // 만기일
    String interestRate;            // 이자율
    String repaymentCondition;      // 상환조건

    @ManyToOne
    @JoinColumn(name = "finance_idx")
    FinanceEntity finance;
}
