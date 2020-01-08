package com.illunex.invest.investorRelations.entity;


import javax.persistence.*;

@Entity
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx", columnDefinition="bigint(20) COMMENT '기본키일련번호'")
    Long financeIdx;
    Long irIdx;
    @Column(name = "currentAsset", columnDefinition = "varchar(255) COMMENT '유동자산'")
    String currentAsset;                // 유동자산
    @Column(name = "currentLiabilities", columnDefinition = "varchar(255) COMMENT '유동부채'")
    String currentLiabilities;          // 유동부채
    @Column(name = "quickAsset", columnDefinition = "varchar(255) COMMENT '당좌자산'")
    String quickAsset;                  // 당좌자산
    @Column(name = "non_currentLiabilities", columnDefinition = "varchar(255) COMMENT '비유동부채'")
    String non_currentLiabilities;      // 비유동부채
    @Column(name = "inventory", columnDefinition = "varchar(255) COMMENT '재고자산'")
    String inventory;                   // 재고자산
    @Column(name = "totalLiabilities", columnDefinition = "varchar(255) COMMENT '부채총계'")
    String totalLiabilities;            // 부채총계
    @Column(name = "non_currentAssets", columnDefinition = "varchar(255) COMMENT '비유동자산'")
    String non_currentAssets;           // 비유동자산
    @Column(name = "contributedCapital", columnDefinition = "varchar(255) COMMENT '자본금'")
    String contributedCapital ;         // 자본금
    @Column(name = "investments", columnDefinition = "varchar(255) COMMENT '투자자산'")
    String investments;                 // 투자자산
    @Column(name = "additional_paid_in_capital", columnDefinition = "varchar(255) COMMENT '자본잉여금'")
    String additional_paid_in_capital;  // 자본잉여금
    @Column(name = "property", columnDefinition = "varchar(255) COMMENT '유형자산'")
    String property;                    // 유형자산
    @Column(name = "retainedEarnings", columnDefinition = "varchar(255) COMMENT '이익잉여금'")
    String retainedEarnings;            // 이익잉여금
    @Column(name = "intangibleAssets", columnDefinition = "varchar(255) COMMENT '무형자산'")
    String intangibleAssets;            // 무형자산
    @Column(name = "otherComprehensiveIncome", columnDefinition = "varchar(255) COMMENT '기타포괄이익'")
    String otherComprehensiveIncome;    // 기타포괄이익
    @Column(name = "otherAssets", columnDefinition = "varchar(255) COMMENT '기타자산'")
    String otherAssets;                 // 기타자산
    @Column(name = "totalEquities", columnDefinition = "varchar(255) COMMENT '자본총계'")
    String totalEquities;               // 자본총계
    @Column(name = "totalAssets", columnDefinition = "varchar(255) COMMENT '자산총계'")
    String totalAssets;                 // 자산총계
    @Column(name = "totalLiabilities_Capital", columnDefinition = "varchar(255) COMMENT '부채및자본총계'")
    String totalLiabilities_Capital;    // 부채및자본총계
    @Column(name = "sales", columnDefinition = "varchar(255) COMMENT '매출액'")
    String sales;                       // 매출액
    @Column(name = "otherRevenue", columnDefinition = "varchar(255) COMMENT '영업외수익'")
    String otherRevenue;                // 영업외수익
    @Column(name = "costOfGoodSold", columnDefinition = "varchar(255) COMMENT '매출원가'")
    String costOfGoodSold;              // 매출원가
    @Column(name = "nonPeratingExpenses", columnDefinition = "varchar(255) COMMENT '영업외비용'")
    String nonPeratingExpenses;         // 영업외비용
    @Column(name = "grossProfit", columnDefinition = "varchar(255) COMMENT '매출총이익'")
    String grossProfit;                 // 매출총이익
    @Column(name = "ordinaryIncome", columnDefinition = "varchar(255) COMMENT '경상이익'")
    String ordinaryIncome;              // 경상이익
    @Column(name = "sg_a", columnDefinition = "varchar(255) COMMENT '판관비'")
    String sg_a;                        // 판관비
    @Column(name = "tax", columnDefinition = "varchar(255) COMMENT '법인세'")
    String tax;                         // 법인세
    @Column(name = "operatingIncome", columnDefinition = "varchar(255) COMMENT '영업이익'")
    String operatingIncome;             // 영업이익
    @Column(name = "netIncome", columnDefinition = "varchar(255) COMMENT '당기순이익'")
    String netIncome;                   // 당기순이익
}
