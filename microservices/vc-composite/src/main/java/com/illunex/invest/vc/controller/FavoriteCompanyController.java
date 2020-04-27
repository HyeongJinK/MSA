package com.illunex.invest.vc.controller;

import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.investment.dto.FavoriteCompanyDTO;
import com.illunex.invest.vc.service.investment.FavoriteCompanyCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
public class FavoriteCompanyController {
    Logger logger = LoggerFactory.getLogger(FavoriteCompanyController.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;
    private final FavoriteCompanyCompositeIntegration favoriteCompanyCompositeIntegration;
    private final String investmentUrl = "http://investment";

    @GetMapping(value = "favorite/list")
    public ResponseEntity<ResponseList> getFavoriteCompanyList() {
        return new ResponseEntity(favoriteCompanyCompositeIntegration.getFavoriteCompanyList(), HttpStatus.OK);
    }

    @GetMapping(value = "favorite/get")
    public ResponseEntity<FavoriteCompanyDTO> getFavoriteCompany(@RequestParam Long companyIdx) {
        return restTemplate.getForEntity(investmentUrl + "/favorite/?companyIdx={companyIdx}", FavoriteCompanyDTO.class, companyIdx);
    }

    @PostMapping(value = "favorite/set")
    public ResponseEntity<String> setFavoriteCompanyList(@RequestBody FavoriteCompanyDTO favoriteCompanyDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        favoriteCompanyDTO.setUserIdx(favoriteCompanyCompositeIntegration.getUser().getId());
        return restTemplate.postForEntity(investmentUrl + "/favorite/set", new HttpEntity(favoriteCompanyDTO, headers), String.class);
    }

}