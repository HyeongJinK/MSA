package com.illunex.invest.vc.controller;

import com.illunex.invest.api.core.investment.dto.*;
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
public class JudgeController {
    Logger logger = LoggerFactory.getLogger(JudgeController.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;
    private final InvestmentCompositeIntegration investmentCompositeIntegration;
    private final String investmentUrl = "http://investment";

    @GetMapping(value = "judge/list")
    public ResponseEntity<ListDTO> getJudgeList() {
        return restTemplate.getForEntity(investmentUrl + "/judge/list?companyIdx={companyIdx}", ListDTO.class, investmentCompositeIntegration.getUser().getCompanyIdx());
    }

    @GetMapping(value = "judge/detail")
    public ResponseEntity<JudgeDTO> getJudge(@RequestParam Long judgeIdx) {
        return restTemplate.getForEntity(investmentUrl + "/judge/detail?judgeIdx={judgeIdx}", JudgeDTO.class, judgeIdx);
    }

    @PostMapping(value = "judge/edit")
    public ResponseEntity<String> editJudge(@RequestBody EditDTO editDTO) {
        editDTO.setCompanyIdx(investmentCompositeIntegration.getUser().getCompanyIdx());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(investmentUrl + "/judge/edit", new HttpEntity(editDTO, headers), String.class);
    }

    @PostMapping(value = "judge/delete")
    public ResponseEntity<String> deleteJudge(@RequestBody JudgeDTO judgeDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(investmentUrl + "/judge/delete", new HttpEntity(judgeDTO, headers), String.class);
    }

}