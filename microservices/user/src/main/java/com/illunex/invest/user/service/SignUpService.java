package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.UserDTO;

public interface SignUpService {
    UserDTO signUp(String username, String password, String name, String vender, Long companyIdx);
}
