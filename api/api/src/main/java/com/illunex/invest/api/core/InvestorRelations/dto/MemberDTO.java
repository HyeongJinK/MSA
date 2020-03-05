package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    Long idx;
    String imgUrl;              // 사진
    String rank;                // 직급
    String name;                // 이름
    String etc;                 // 비고
}
