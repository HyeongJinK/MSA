package com.illunex.invest.startup.service.user;

import com.illunex.invest.api.core.communication.model.SignUpMailRequest;
import com.illunex.invest.api.core.company.model.CompanyRegisterRequest;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.model.SignInRequest;
import com.illunex.invest.api.core.user.model.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class UserCompositeIntegration {
    Logger logger = LoggerFactory.getLogger(UserCompositeIntegration.class);

    private final RestTemplate restTemplate;
    //private final WebClient.Builder loadBalanceWebClientBuilder;

    private final String userUrl = "http://user";
    private final String companyUrl = "http://company";
    private final String communicationUrl = "http://communication";
    private final String startUpUrl = "https://startup.effectmall.com";

    public UserDTO signIn(String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            return restTemplate.postForObject(userUrl + "/signIn", new HttpEntity<>(new SignInRequest(username, ""), headers), UserDTO.class);
        } catch (RestClientException e) { // 에러인 경우 RestClientException 을 내뱉는다.
            e.printStackTrace();
        }
        return null;
    }
    
    public ResponseEntity<HashMap<String, Object>> signUp(String username, String password, String name, String businessNumber, String vender) {
        HashMap<String, Object> result = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //  사용자 추가
        logger.debug("=======================================");
        logger.debug(username);
        logger.debug(password);
        logger.debug(name);
        logger.debug(businessNumber);
        logger.debug(restTemplate.toString());
        logger.debug("=======================================");
        Long companyIdx = restTemplate.postForObject(companyUrl + "/register", new HttpEntity<>(new CompanyRegisterRequest(businessNumber), headers), Long.class);
        result.put("companyIdx", companyIdx);
        UserDTO user = restTemplate.postForObject(userUrl + "/signUp", new HttpEntity<>(new SignUpRequest(username, password, name, vender, companyIdx), headers), UserDTO.class);
        result.put("user", user);
        logger.debug(user.getId().toString());
        //  인증 메일 보내기
        restTemplate.postForObject(communicationUrl + "/mail/signUp", new HttpEntity<>(new SignUpMailRequest(user.getUsername(), startUpUrl+"/user/register/confirm?token="+user.getToken()), headers), String.class);

        // 결과 리턴
        return new ResponseEntity<HashMap<String, Object>>(result, HttpStatus.OK);
    }
}
