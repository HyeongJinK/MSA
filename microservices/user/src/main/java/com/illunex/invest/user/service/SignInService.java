package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.UserDTO;

public interface SignInService {
    UserDTO findByUsername(String username);
}
