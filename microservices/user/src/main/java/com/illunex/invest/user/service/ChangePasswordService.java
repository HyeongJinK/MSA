package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.UserDTO;

public interface ChangePasswordService {
    UserDTO changePassword(String username, String prePassword, String password);
}
