package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinancialStatusDTO {
    Long idx;
    String borrower;                // 차입처
    String borrowingAmount;         // 차입금액
    String expiryDate;              // 만기일
    String interestRate;            // 이자율
    String repaymentCondition;      // 상환조건
}
