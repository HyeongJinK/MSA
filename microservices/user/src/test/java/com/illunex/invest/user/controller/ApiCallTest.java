package com.illunex.invest.user.controller;

import com.illunex.invest.api.core.user.model.SignInRequest;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ApiCallTest {
    @Test
    public void test() {
        String url = "http://localhost:7401/signIn";
//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
//        Map map = new HashMap<String, String>();
//        map.put("Content-Type", "application/json");
//
//        headers.setAll(map);
//
//        Map req_payload = new HashMap();
//        req_payload.put("username", "test");
//        req_payload.put("password", "test1234");
//
//        HttpEntity<?> request = new HttpEntity<>(req_payload, headers);

//
//        ResponseEntity<?> response = new RestTemplate().postForEntity(url, request, String.class);






        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

//        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
//        map.add("username", "test");
//        map.add("password", "test1234");
        HashMap req_payload = new HashMap();
        req_payload.put("username", "test");
        req_payload.put("password", "test1234");
        //String param = "{'username':'test','password': 'test1234'}";
        SignInRequest param = new SignInRequest("test", "test1234");
        HttpEntity<SignInRequest> request = new HttpEntity<SignInRequest>(param, headers);

        String response = new RestTemplate().postForObject(url, request , String.class );

        System.out.println(response);
    }
}
