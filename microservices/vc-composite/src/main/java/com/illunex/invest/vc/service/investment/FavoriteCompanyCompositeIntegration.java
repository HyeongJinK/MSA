package com.illunex.invest.vc.service.investment;

import com.illunex.invest.api.core.company.dto.VcFavoriteCompanyListDTO;
import com.illunex.invest.api.core.investment.FavoriteCompanyDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateStateDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateStateListDTO;
import com.illunex.invest.vc.service.DefaultIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class FavoriteCompanyCompositeIntegration extends DefaultIntegrationService {
    Logger logger = LoggerFactory.getLogger(FavoriteCompanyCompositeIntegration.class);

    public FavoriteCompanyCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    private final String companyUrl = "http://company";
    private final String investmentUrl = "http://investment";

    public FavoriteCompanyDTO getFavoriteCompanyList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        VcFavoriteCompanyListDTO favoriteCompanyList = restTemplate.getForObject(companyUrl + "/vc/favorite/list?userIdx={userIdx}", VcFavoriteCompanyListDTO.class, getUser().getId());
        List<EvaluateStateDTO> evaluateList = restTemplate.getForEntity(investmentUrl + "/evaluate/list/state?companyIdx={companyIdx}", EvaluateStateListDTO.class, getUser().getCompanyIdx()).getBody().getEvaluateState();

        return FavoriteCompanyDTO.builder()
                .vcFavoriteCompanyList(favoriteCompanyList)
                .evaluateStateList(evaluateList)
                .build();
    }

}
