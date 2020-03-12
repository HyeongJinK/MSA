package com.illunex.invest.user.service;

import com.illunex.invest.user.exception.BadCredentialsException;

import java.util.HashMap;

public interface ChangePasswordService {
    HashMap<String, Object> changePassword(String username, String prePassword, String password) throws BadCredentialsException;
}
