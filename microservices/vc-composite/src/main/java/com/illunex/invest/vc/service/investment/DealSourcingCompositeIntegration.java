package com.illunex.invest.vc.service.investment;

import com.illunex.invest.api.core.company.dto.VcCompanyListDTO;
import com.illunex.invest.api.core.investment.dto.DealSourcingDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateStateListDTO;
import com.illunex.invest.vc.service.DefaultIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class DealSourcingCompositeIntegration extends DefaultIntegrationService {
    Logger logger = LoggerFactory.getLogger(DealSourcingCompositeIntegration.class);

    @Autowired
    WebClient.Builder webClientBuilder;

    public DealSourcingCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    private final String investmentUrl = "http://investment";
    private final String companyUrl = "http://company";

    public DealSourcingDTO getDealSourcingList() {
        WebClient webClient = webClientBuilder.build();

        Mono<VcCompanyListDTO> companyList = webClient
                .get()
                .uri(companyUrl + "/vc/company/list")
                .retrieve()
                .bodyToMono(VcCompanyListDTO.class);

        Mono<EvaluateStateListDTO> evaluateList = webClient
                .get()
                .uri(investmentUrl + "/evaluate/list/state?companyIdx={companyIdx}", getUser().getCompanyIdx())
                .retrieve()
                .bodyToMono(EvaluateStateListDTO.class);

        return Mono.zip(companyList, evaluateList).map(t -> DealSourcingDTO.builder()
                .companyList(t.getT1().getVcCompanyList())
                .evaluateStateList(t.getT2().getEvaluateState())
                .build()).block();
    }
}
