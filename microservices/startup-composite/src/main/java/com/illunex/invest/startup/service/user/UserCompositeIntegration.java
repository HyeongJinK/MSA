package com.illunex.invest.startup.service.user;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.user.model.JwtResponse;
import com.illunex.invest.api.core.user.model.SignInRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class UserCompositeIntegration {
    private final RestTemplate restTemplate;

    private final String userUrl = "http://user";
    private final String cmpanyUrl = "http://company";

    public UserCompositeIntegration(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<JwtResponse> signIn(SignInRequest signInRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("username", "test");
        map.add("password", "test1234");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<JwtResponse> response = restTemplate.postForEntity(userUrl + "/signIn", request , JwtResponse.class );

//        ResponseEntity<JwtResponse> data = restTemplate.postForEntity(userUrl + "/signIn", signInRequest, JwtResponse.class);
//        System.out.println(userUrl);
        return response;
    }

    public CompanyDTO getCompanyByUserIdx(Long userIdx) {
        ResponseEntity<CompanyDTO> data = restTemplate.getForEntity(cmpanyUrl + "/company/user/1", CompanyDTO.class);
        return data.getBody();
    }
}
