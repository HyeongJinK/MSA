package com.illunex.invest.vc.service.investment;

import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.investment.dto.ListDTO;
import com.illunex.invest.vc.service.DefaultIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class FavoriteCompanyCompositeIntegration extends DefaultIntegrationService {
    Logger logger = LoggerFactory.getLogger(FavoriteCompanyCompositeIntegration.class);

    public FavoriteCompanyCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    private final String investmentUrl = "http://investment";
    private final String companyUrl = "http://company";

    public ResponseList getFavoriteCompanyList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ListDTO favoriteList = restTemplate.getForObject(investmentUrl + "/favorite/list?userIdx={userIdx}", ListDTO.class, getUser().getId());
        return restTemplate.postForObject(companyUrl + "/company/favorite/", new HttpEntity(favoriteList, headers), ResponseList.class);
    }

}
