package com.illunex.invest.api.core.ir.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    Long idx;
    String imgUrl;              // 사진
    String imgStatus;           // 사진 저장 유무
    String rank;                // 직급
    String name;                // 이름
    String etc;                 // 비고
}
