package com.illunex.invest.api.core.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    String username;
    String password;
    String name;
    String vender;
    Long companyIdx;
}
