package com.illunex.invest.user.service;

import com.illunex.invest.user.exception.DuplicateUserException;
import com.illunex.invest.user.exception.UsernameNotFoundException;
import com.illunex.invest.user.exception.UsernameSearchEmptyException;
import com.illunex.invest.user.persistence.entity.User;

public class UserService {
    protected void userNullCheck(User currentUser) {
        if (currentUser == null) {
            throw new UsernameSearchEmptyException("유저가 없습니다.");
        }
    }

    protected void usernameParameterCheck(String username) {
        if (username == null || username.equals("")) {
            throw new UsernameNotFoundException("Username 파라미터가 없습니다.");
        }
    }

    protected void DuplicateUserCheck(User user) {
        if (user != null) {
            throw new DuplicateUserException("중복된 유저가 있습니다.");
        }
    }
}
