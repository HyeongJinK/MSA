package com.illunex.invest.startup.service.user;

import com.illunex.invest.api.core.user.dto.UserDTO;

public interface SignUpService {
    UserDTO signUp(String username, String password, String name);
}
