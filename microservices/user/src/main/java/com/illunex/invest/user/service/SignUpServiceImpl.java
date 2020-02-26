package com.illunex.invest.user.service;

import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final UserRepository userRepository;

    public User signUp(String username, String password, String name, String vender) {
        return userRepository.save(User.createUser(username, password, name, vender));
    }
}
