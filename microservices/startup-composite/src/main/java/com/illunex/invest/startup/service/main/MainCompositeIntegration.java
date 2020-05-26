package com.illunex.invest.startup.service.main;

import com.illunex.invest.api.core.company.dto.CompanyWriteCheckDTO;
import com.illunex.invest.api.core.main.dto.WriteCheckDTO;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class MainCompositeIntegration extends DefaultIntegrationService {
    Logger logger = LoggerFactory.getLogger(MainCompositeIntegration.class);

    @Autowired
    WebClient.Builder webClientBuilder;

    public MainCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    private final String companyUrl = "http://company";
    private final String irUrl = "http://ir";

    public WriteCheckDTO getWriteCheck() {
        WebClient webClient = webClientBuilder.build();

        Mono<CompanyWriteCheckDTO> companyWriteCheck = webClient
                .get()
                .uri(companyUrl + "/check?companyIdx={companyIdx}", getUser().getCompanyIdx())
                .retrieve()
                .bodyToMono(CompanyWriteCheckDTO.class);

        Mono<String> irWriteCheck = webClient
                .get()
                .uri(irUrl + "/check?companyIdx={companyIdx}", getUser().getCompanyIdx())
                .retrieve()
                .bodyToMono(String.class);

        return Mono.zip(companyWriteCheck, irWriteCheck).map(t -> WriteCheckDTO.builder()
                .businessRegistrationStatus(t.getT1().getBusinessRegistrationStatus())
                .CorporateInformationStatus(t.getT1().getCorporateInformationStatus())
                .IRStatus(t.getT2())
                .build()).block();

    }
}
