package com.illunex.invest.ir.persistence.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "finance")
public class FinanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String currentAsset;                // 유동자산
    String currentLiabilities;          // 유동부채
    String quickAsset;                  // 당좌자산
    String nonCurrentLiabilities;       // 비유동부채
    String inventories;                 // 재고자산
    String totalLiabilities;            // 부채총계
    String nonCurrentAssets;            // 비유동자산
    String capital;                     // 자본금
    String totalCapital;                // 자본총계
    String investments;                 // 투자자산
    String surplus;                     // 자본잉여금
    String tangibleAssets;              // 유형자산
    String retainedEarnings;            // 이익잉여금
    String intangibleAssets;            // 무형자산
    String otherComprehensiveIncome;    // 기타포괄이익
    String otherAssets;                 // 기타자산
    String sales;                       // 매출액
    String otherRevenue;                // 영업외수익
    String cost;                        // 매출원가
    String nonOperatingExpenses;        // 영업외비용
    String grossProfit;                 // 매출총이익
    String ordinaryProfit;              // 경상이익
    String sga;                         // 판관비
    String tax;                         // 법인세
    String operatingProfit;             // 영업이익
    String netIncome;                   // 당기순이익

    @OneToOne(mappedBy = "finance", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    IREntity ir;

    @OneToMany(mappedBy = "finance", cascade = CascadeType.ALL)
    List<FinancialStatusEntity> financialStatus;   // 주요채무현황
}
