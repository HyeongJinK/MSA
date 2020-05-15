package com.illunex.invest.startup.service.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProfileIntegrationService extends DefaultIntegrationService {
    public ProfileIntegrationService(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public ResponseEntity<ResponseData> getProfile() {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(restTemplate.getForObject(userUrl + "/profile?userIdx="+getUser().getId(), UserDTO.class))
                .build());
    }

    public ResponseEntity<ResponseData> editProfile(UserDTO userDTO) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(restTemplate.postForObject(userUrl + "/profile"
                        , new HttpEntity<>(userDTO, getDefaultHeader())
                        , UserDTO.class))
                .build());
    }
}
