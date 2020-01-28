package com.illunex.invest.investorRelations.entity;


import javax.persistence.*;

@Entity
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long financeIdx;
    Long irIdx;
    String currentAsset;                // 유동자산
    String currentLiabilities;          // 유동부채
    String quickAsset;                  // 당좌자산
    String non_currentLiabilities;      // 비유동부채
    String inventory;                   // 재고자산
    String totalLiabilities;            // 부채총계
    String non_currentAssets;           // 비유동자산
    String contributedCapital;          // 자본금
    String investments;                 // 투자자산
    String additional_paid_in_capital;  // 자본잉여금
    String property;                    // 유형자산
    String retainedEarnings;            // 이익잉여금
    String intangibleAssets;            // 무형자산
    String otherComprehensiveIncome;    // 기타포괄이익
    String otherAssets;                 // 기타자산
    String totalEquities;               // 자본총계
    String totalAssets;                 // 자산총계
    String totalLiabilities_Capital;    // 부채및자본총계
    String sales;                       // 매출액
    String otherRevenue;                // 영업외수익
    String costOfGoodSold;              // 매출원가
    String nonPeratingExpenses;         // 영업외비용
    String grossProfit;                 // 매출총이익
    String ordinaryIncome;              // 경상이익
    String sg_a;                        // 판관비
    String tax;                         // 법인세
    String operatingIncome;             // 영업이익
    String netIncome;                   // 당기순이익
}
