package com.illunex.invest.investorRelations.entity;

public class InvestorRelations {
    Long irIdx;
    String year;            // 년도
    Long companyIdx;        // 회사 기본키
    Boolean isPassword;     // 패스워드 사용유/무
    String password;        // 패스워드
    String progress;        // 작성 %
    String cardColor;       // 카드 색상
}
