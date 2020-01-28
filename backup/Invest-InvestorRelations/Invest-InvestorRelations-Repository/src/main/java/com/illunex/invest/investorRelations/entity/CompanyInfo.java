package com.illunex.invest.investorRelations.entity;

import com.illunex.invest.investorRelations.entity.enumable.NationType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class CompanyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ciIdx;
    Long irIdx;
    String name;                // 기업명
    String address;             // 주소
    Date establishmentDate;     // 설립일
    String corporateNumber;     // 법인등록번호
    String ceo;                 // 대표
    String employeeCount;       // 직원수
    String companyType;         // 기업형태
    String homePage;            // 웹사이트
    String business;            // 업종
    String businessNumber;      // 사업자 등록번호
    String phone;               // 연락처
    String equities;            // 자본금
    String faceValue;           // 액면가
    String totalStocks;         // 총발행주식수
    String settlement;          // 결산기
    String valuation;           // Valuation
    String useInvestment;       // 투자금 사용용도
    String exitPlan;            // EXIT 계획
    @OneToMany
    List<InvestmentAttraction> investmentAttractions;  // 기존투자유치
    @OneToMany
    List<Subsidy> subsidies;
    // 지원금
}
