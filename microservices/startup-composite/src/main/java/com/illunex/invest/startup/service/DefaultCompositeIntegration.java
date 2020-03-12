package com.illunex.invest.startup.service;

import com.illunex.invest.api.core.user.dto.UserDTO;
import org.springframework.security.core.context.SecurityContextHolder;

public class DefaultCompositeIntegration {
    protected UserDTO getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null) {
            UserDTO userDetails = (UserDTO) principal;

            return userDetails;
        }
        else {
            return null;
        }
    }
}
