package com.illunex.invest.startup.service.user;

import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.model.SignInRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class UserCompositeIntegration {
    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;

    private final String userUrl = "http://user";

    public UserCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        this.restTemplate = restTemplate;
        this.loadBalanceWebClientBuilder = loadBalanceWebClientBuilder;
    }

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
}
