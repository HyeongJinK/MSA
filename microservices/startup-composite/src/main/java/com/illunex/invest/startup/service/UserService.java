package com.illunex.invest.startup.service;

import com.illunex.invest.api.core.user.model.SignInRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;
    // TODO 따로 설정파일로 빼기
    private final String userUrl = "http://user";

    public void signIn(SignInRequest request) {
        //ResponseEntity<Object> data =
    }
}
