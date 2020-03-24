package com.illunex.invest.api.core.ir.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IRDTO {
    Long idx;
    String year;                    // 년도
    Long companyIdx;                // 회사 기본키
    Boolean isPassword;             // 패스워드 사용유/무
    String progress;                // 작성 %
    String cardColor;               // 카드 색상
    LocalDateTime updateDate;       // 마지막 수정일
    Integer readCount;              // 조회수
}
