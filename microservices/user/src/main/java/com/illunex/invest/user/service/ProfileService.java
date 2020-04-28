package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.UserDTO;

public interface ProfileService {
    UserDTO getUser(Long userIdx);
    UserDTO editUser(UserDTO userDTO);
}
