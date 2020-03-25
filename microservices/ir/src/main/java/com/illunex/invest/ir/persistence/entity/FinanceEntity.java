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

    // 유동자산 = 당좌자산 + 재고자산 + 기타자산(기타 유동 + 기타 비유동)
    String quickAsset;                  // 당좌자산
    String inventories;                 // 재고자산
    String otherCurrentAsset;           // 기타 유동자산
    String otherNonCurrentAssets;       // 기타 비유동자산
    // 비유동자산 = 투자자산 + 유형자산 + 무형자산
    String investments;                 // 투자자산
    String tangibleAssets;              // 유형자산
    String intangibleAssets;            // 무형자산
    // 자산총계 = (유동자산) + (비유동자산)

    // 부채총계 = 유동부채 + 비유동부채
    String currentLiabilities;          // 유동부채
    String nonCurrentLiabilities;       // 비유동부채
    // 자본총계 = 자본금 + 자본잉여금 + 자본조정 + 기타포괄손익 누계액 + 이익잉여금
    String capital;                     // 자본금
    String surplus;                     // 자본잉여금
    String capitalAdjustment;           // 자본조정
    String otherComprehensiveIncome;    // 기타포괄손익 누계액
    String retainedEarnings;            // 이익잉여금
    // 부채와 자본총계 = (부채총계) + (자본총계)

    // 손익계산서
    String sales;                       // 매출액
    String cost;                        // 매출원가
    // 매출총이익 = 매출액 - 매출원가
    String sga;                         // 판매관리비
    // 영업이익 = 매출액 - 매출원가 - 판매관리비
    String otherRevenue;                // 영업외수익
    String nonOperatingExpenses;        // 영업외비용
    // 경상이익 = 영업이익 + 영업외수익 - 영업외비용
    String tax;                         // 법인세
    // 당기순이익 = 경상이익 - 법인세

    @OneToOne(mappedBy = "finance", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    IREntity ir;

    @OneToMany(mappedBy = "finance", cascade = CascadeType.ALL)
    List<FinancialStatusEntity> financialStatus;   // 주요채무현황
}
