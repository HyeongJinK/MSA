package com.illunex.invest.user.service;

import com.illunex.invest.user.exception.BadCredentialsException;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class ChangePasswordServiceImpl extends UserService implements ChangePasswordService {
    private final UserRepository userRepository;

    @Override
    public HashMap<String, Object> changePassword(String username, String prePassword, String password) throws BadCredentialsException {
        HashMap<String, Object> result = new HashMap<>();
        User user = userRepository.findByUsername(username);
        userNullCheck(user);

        passwordCheck(prePassword, user);

        user.setPassword(password);
        result.put("status", 200);
        result.put("message", "success");
        return result;
    }

    private void passwordCheck(String prePassword, User user) throws BadCredentialsException {
        if (!User.matchPassword(user.getPassword(), prePassword)) {
            throw new BadCredentialsException("비밀번호가 틀렸습니다.");
        }
    }
}
