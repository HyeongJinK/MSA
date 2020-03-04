package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.user.persistence.entity.User;

public interface SignInService {
    UserDTO findByUsername(String username);
}
