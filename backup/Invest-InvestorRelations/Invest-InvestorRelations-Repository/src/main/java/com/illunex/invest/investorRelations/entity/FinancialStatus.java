package com.illunex.invest.investorRelations.entity;

import javax.persistence.*;

@Entity
public class FinancialStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long financialStatusIdx;
    String borrower;                // 차입처
    String borrowingAmount;         // 차입금액
    String expiryDate;              // 만기일
    String interestRate;            // 이자율
    String repaymentCondition;      // 상환조건
}
