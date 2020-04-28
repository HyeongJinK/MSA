package com.illunex.invest.vc.controller;

import com.illunex.invest.api.core.investment.dto.ListDTO;
import com.illunex.invest.api.core.investment.dto.ReviewItemTemplateDTO;
import com.illunex.invest.vc.service.investment.InvestmentCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
public class ReviewItemController {
    Logger logger = LoggerFactory.getLogger(ReviewItemController.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;
    private final InvestmentCompositeIntegration investmentCompositeIntegration;
    private final String investmentUrl = "http://investment";

    @GetMapping(value = "review/list")
    public ResponseEntity<ListDTO> getReviewItemList() {
        return restTemplate.getForEntity(investmentUrl + "/review/list?companyIdx={companyIdx}", ListDTO.class, investmentCompositeIntegration.getUser().getCompanyIdx());
    }

    @GetMapping(value = "review/detail")
    public ResponseEntity<ReviewItemTemplateDTO> getReviewItem(@RequestParam Long templateIdx) {
        return restTemplate.getForEntity(investmentUrl + "/review/detail?templateIdx={templateIdx}", ReviewItemTemplateDTO.class, templateIdx);
    }

    @PostMapping(value = "review/edit")
    public ResponseEntity<String> editReviewItem(@RequestBody ReviewItemTemplateDTO reviewItemTemplateDTO) {
        reviewItemTemplateDTO.setCompanyIdx(investmentCompositeIntegration.getUser().getCompanyIdx());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(investmentUrl + "/review/edit", new HttpEntity(reviewItemTemplateDTO, headers), String.class);
    }

    @PostMapping(value = "review/delete")
    public ResponseEntity<String> deleteReviewItem(@RequestBody ReviewItemTemplateDTO reviewItemTemplateDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(investmentUrl + "/review/delete", new HttpEntity(reviewItemTemplateDTO, headers), String.class);
    }

}