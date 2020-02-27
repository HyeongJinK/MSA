package com.illunex.invest.api.core.user.model;

import lombok.Getter;

@Getter
public class ChangePasswordRequest {
    String username;
    String prePassword;
    String password;
}
