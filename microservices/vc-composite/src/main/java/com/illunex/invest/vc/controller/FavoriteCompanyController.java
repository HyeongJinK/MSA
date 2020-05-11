package com.illunex.invest.vc.controller;

import com.illunex.invest.api.core.company.dto.VcFavoriteCompanyDTO;
import com.illunex.invest.api.core.investment.FavoriteCompanyDTO;
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
    private final String companyUrl = "http://company";

    @GetMapping(value = "favorite/list")
    public ResponseEntity<FavoriteCompanyDTO> getFavoriteCompanyList() {
        return new ResponseEntity(favoriteCompanyCompositeIntegration.getFavoriteCompanyList(), HttpStatus.OK);
    }

    @GetMapping(value = "favorite/get")
    public ResponseEntity<VcFavoriteCompanyDTO> getFavoriteCompany(@RequestParam Long companyIdx) {
        return restTemplate.getForEntity(companyUrl + "/vc/favorite/?companyIdx={companyIdx}", VcFavoriteCompanyDTO.class, companyIdx);
    }

    @PostMapping(value = "favorite/set")
    public ResponseEntity<String> setFavoriteCompanyList(@RequestBody VcFavoriteCompanyDTO vcFavoriteCompanyDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        vcFavoriteCompanyDTO.setUserIdx(favoriteCompanyCompositeIntegration.getUser().getId());
        return restTemplate.postForEntity(companyUrl + "/vc/favorite/set", new HttpEntity(vcFavoriteCompanyDTO, headers), String.class);
    }

}