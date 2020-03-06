package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordDTO {
    Long irIdx;
    String password;                  // 현재 비밀번호
    String newPassword;               // 새 비밀번호
}
