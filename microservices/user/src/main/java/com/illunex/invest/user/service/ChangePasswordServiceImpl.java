package com.illunex.invest.user.service;

import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ChangePasswordServiceImpl extends UserService implements ChangePasswordService {
    private final UserRepository userRepository;

    @Override
    public String changePassword(String username, String prePassword, String password) {
        User user = userRepository.findByUsername(username);
        userNullCheck(user);

        passwordCheck(prePassword, user);

        user.setPassword(User.encodePassword(password));

        return "success";
    }

    private void passwordCheck(String prePassword, User user) throws BadCredentialsException {
        if (!User.matchPassword(user.getPassword(), prePassword)) {
            throw new BadCredentialsException("비밀번호가 틀렸습니다.");
        }
    }
}
