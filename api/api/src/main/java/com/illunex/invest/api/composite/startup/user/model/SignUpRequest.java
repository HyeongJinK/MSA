package com.illunex.invest.api.composite.startup.user.model;

import lombok.Getter;

@Getter
public class SignUpRequest {
    String username;
    String password;
    String name;
    String businessNumber;
}
