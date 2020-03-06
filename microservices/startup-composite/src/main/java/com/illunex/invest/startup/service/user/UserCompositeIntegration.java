package com.illunex.invest.startup.service.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.illunex.invest.api.core.board.dto.BoardDTO;
import com.illunex.invest.api.core.company.model.CompanyRegisterRequest;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.model.SignInRequest;
import com.illunex.invest.api.core.user.model.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserCompositeIntegration {
    Logger logger = LoggerFactory.getLogger(UserCompositeIntegration.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;

    private final String userUrl = "http://user";
    private final String companyUrl = "http://company";

    public UserDTO signIn(String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            UserDTO response = restTemplate.postForObject(userUrl + "/signIn", new HttpEntity(new SignInRequest(username, ""), headers), UserDTO.class);
            return response;
        } catch (RestClientException e) { // 에러인 경우 RestClientException 을 내뱉는다.
            e.printStackTrace();
        }
        return null;
    }

    class test {
        Page<UserDTO> page = null;
    }
    
    public ResponseEntity<HashMap> signUp(String username, String password, String name, String businessNumber) {
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
        UserDTO user = restTemplate.postForObject(userUrl + "/signUp", new HttpEntity(new SignUpRequest(username, password, name), headers), UserDTO.class);
        result.put("user", user);
        logger.debug(user.getId().toString());
        //  해당 사용자의 기업추가

        result.put("companyIdx", restTemplate.postForObject(companyUrl + "/register", new HttpEntity(new CompanyRegisterRequest(user.getId(), businessNumber), headers), Long.class));
        // TODO 인증 메일 보내기

        // 결과 리턴
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
