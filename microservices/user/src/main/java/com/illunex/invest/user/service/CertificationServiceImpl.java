package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.exception.UsernameNotFoundException;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CertificationServiceImpl implements CertificationService {
    private final UserRepository userRepository;

    @Override
    public String certification(String token) {
        User user = userRepository.findByToken(token);

        if (user == null) {
            throw new UsernameNotFoundException("잘못된 유저입니다.");
        } else {
            user.setCertification(true);
            userRepository.save(user);
        }

        return "success";
    }
}
