package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IRDTO {
    Long irIdx;
    String year;            // 년도
    Long companyIdx;        // 회사 기본키
    Boolean isPassword;     // 패스워드 사용유/무
    String password;        // 패스워드
    String progress;        // 작성 %
    String cardColor;       // 카드 색상
    Date updateDate;        // 마지막 수정일
    Integer readCount;      // 조회수
}
