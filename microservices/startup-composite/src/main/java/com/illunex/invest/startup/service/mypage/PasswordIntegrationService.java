package com.illunex.invest.startup.service.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.user.exception.UsernameSearchEmptyException;
import com.illunex.invest.api.core.user.request.ChangePasswordRequest;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PasswordIntegrationService extends DefaultIntegrationService {
    public PasswordIntegrationService(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    //@HystrixCommand(fallbackMethod = "changePasswordError")
    public ResponseEntity<ResponseData> changePassword(String prePassword, String password) {
      //  System.out.println(prePassword, password);
        return restTemplate.postForEntity(userUrl + "/changePassword"
                , new HttpEntity<>(new ChangePasswordRequest(getUser().getUsername(), prePassword, password)
                        , getDefaultHeader())
                , ResponseData.class);
    }

//    public ResponseEntity<ResponseData> changePasswordError(String prePassword, String password) {
//        throw new UsernameSearchEmptyException("통신에 장애가 있습니다.");
//    }
}
