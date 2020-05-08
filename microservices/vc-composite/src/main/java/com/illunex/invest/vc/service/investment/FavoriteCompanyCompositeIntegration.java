package com.illunex.invest.vc.service.investment;

import com.illunex.invest.api.core.company.dto.VcFavoriteCompanyListDTO;
import com.illunex.invest.api.core.investment.FavoriteCompanyDTO;
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
public class FavoriteCompanyCompositeIntegration extends DefaultIntegrationService {
    Logger logger = LoggerFactory.getLogger(FavoriteCompanyCompositeIntegration.class);

    @Autowired
    WebClient.Builder webClientBuilder;

    public FavoriteCompanyCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    private final String companyUrl = "http://company";
    private final String investmentUrl = "http://investment";

    public FavoriteCompanyDTO getFavoriteCompanyList() {
        WebClient webClient = webClientBuilder.build();

        Mono<VcFavoriteCompanyListDTO> favoriteCompanyList = webClient
                .get()
                .uri(companyUrl + "/vc/favorite/list?userIdx={userIdx}", getUser().getId())
                .retrieve()
                .bodyToMono(VcFavoriteCompanyListDTO.class);

        Mono<EvaluateStateListDTO> evaluateList = webClient
                .get()
                .uri(investmentUrl + "/evaluate/list/state?companyIdx={companyIdx}", getUser().getCompanyIdx())
                .retrieve()
                .bodyToMono(EvaluateStateListDTO.class);

        return Mono.zip(favoriteCompanyList, evaluateList).map(t -> FavoriteCompanyDTO.builder()
                .vcFavoriteCompanyList(t.getT1())
                .evaluateStateList(t.getT2().getEvaluateState())
                .build()).block();
    }

}
