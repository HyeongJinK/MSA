package com.illunex.invest.api.core.user.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChangePasswordRequest extends MyPageChangePasswordRequest {
    String username;

    public ChangePasswordRequest(String username, String prePassword, String password) {
        super(prePassword, password);
        this.username = username;
    }
}
