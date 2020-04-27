package com.illunex.invest.startup.service.alarm;

import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AlarmCompositeIntegration extends DefaultIntegrationService {
    public AlarmCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public ResponseEntity<ResponseList> getList() {
        return restTemplate.getForEntity(communicationUrl + "/alarm?userId="+getUser().getId(), ResponseList.class);
    }

}
