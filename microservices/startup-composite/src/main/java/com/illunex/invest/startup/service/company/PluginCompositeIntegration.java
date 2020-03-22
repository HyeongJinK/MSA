package com.illunex.invest.startup.service.company;

import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class PluginCompositeIntegration extends DefaultIntegrationService {
    public PluginCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    // TODO 플러그인 목록, 플러그인 토글, 플러그인 설치, 활성, 비활성

}
