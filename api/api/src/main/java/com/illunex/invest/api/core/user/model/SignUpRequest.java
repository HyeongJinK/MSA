package com.illunex.invest.api.core.user.model;

import lombok.Getter;

@Getter
public class SignUpRequest {
    String username;
    String password;
    String name;
}
