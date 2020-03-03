package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasicInfoDTO {
    Long idx;
    Long irIdx;
    String name;                         // 기업명
    String address;                      // 주소
    LocalDateTime establishmentDate;     // 설립일
    String corporateNumber;              // 법인등록번호
    String ceo;                          // 대표
    String employeeCount;                // 직원수
    String companyType;                  // 기업형태
    String homePage;                     // 웹사이트
    String business;                     // 업종
    String businessNumber;               // 사업자 등록번호
    String phone;                        // 연락처
    String equities;                     // 자본금
    String faceValue;                    // 액면가
    String totalStocks;                  // 총발행주식수
    String settlement;                   // 결산기
    String valuation;                    // Valuation
    String useInvestment;                // 투자금 사용용도
    String exitPlan;                     // EXIT 계획

    List<AttractionDTO> attraction;      // 기존투자유치
    List<SubsidyDTO> subsidy;            // 지원금
}
