package com.illunex.invest.vc.service.invest;

import com.illunex.invest.vc.service.DefaultIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class InvestCompositeIntegration extends DefaultIntegrationService {
    Logger logger = LoggerFactory.getLogger(InvestCompositeIntegration.class);

    public InvestCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

}
