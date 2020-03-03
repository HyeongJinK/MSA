package com.illunex.invest.startup.service.user;

import com.illunex.invest.startup.exception.user.DuplicateUserException;
import com.illunex.invest.startup.exception.user.UsernameSearchEmptyException;
import com.illunex.invest.startup.persistence.user.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
