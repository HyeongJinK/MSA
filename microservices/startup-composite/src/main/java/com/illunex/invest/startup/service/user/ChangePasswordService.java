package com.illunex.invest.startup.service.user;

import com.illunex.invest.api.core.user.dto.UserDTO;

public interface ChangePasswordService {
    UserDTO changePassword(String username, String prePassword, String password);
}
