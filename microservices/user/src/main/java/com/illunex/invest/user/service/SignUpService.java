package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.UserInfoDTO;

public interface SignUpService {
    UserInfoDTO signUp(String username, String password, String name, String vender, Long companyIdx);
    UserInfoDTO invite(String username, String password, String name, String vender, Long companyIdx);
}
