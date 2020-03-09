package com.illunex.invest.user.service;

import com.illunex.invest.user.exception.UsernameNotFoundException;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CertificationServiceImpl implements CertificationService {
    private final UserRepository userRepository;

    @Override
    public Map<String, Object> certification(String token) {
        User user = userRepository.findByToken(token);
        HashMap<String, Object> result = new HashMap<>();

        if (user == null) {
            throw new UsernameNotFoundException("empty User");
        } else {
            user.setCertification(true);
            userRepository.save(user);
        }
        result.put("message", "success");
        return result;
    }
}
