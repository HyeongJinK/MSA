package com.illunex.invest.authorization.payload;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignUpRequest {
    private String name;
    private String userName;
    private String password;
}
