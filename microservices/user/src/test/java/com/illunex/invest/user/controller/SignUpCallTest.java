package com.illunex.invest.user.controller;

import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.model.SignUpRequest;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class SignUpCallTest {
    @Test
    public void test() {
        String url = "http://localhost:7401/signUp";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

//        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
//        map.add("username", "test");
//        map.add("password", "test1234");
        HashMap req_payload = new HashMap();
        req_payload.put("username", "test");
        req_payload.put("password", "test1234");
        //String param = "{'username':'test','password': 'test1234'}";
        SignUpRequest param = new SignUpRequest("test3", "test1234", "akdsjfk", "illunex", 1L);
        HttpEntity<SignUpRequest> request = new HttpEntity<>(param, headers);

        UserDTO response = new RestTemplate().postForObject(url, request , UserDTO.class );

        System.out.println(response);
    }
}
