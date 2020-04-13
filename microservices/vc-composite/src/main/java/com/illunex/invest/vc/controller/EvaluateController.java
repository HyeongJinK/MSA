package com.illunex.invest.vc.controller;

import com.illunex.invest.api.core.investment.dto.EvaluateDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateListDTO;
import com.illunex.invest.api.core.investment.dto.JudgeDTO;
import com.illunex.invest.api.core.investment.dto.ReviewItemDTO;
import com.illunex.invest.vc.service.invest.InvestCompositeIntegration;
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
public class EvaluateController {
    Logger logger = LoggerFactory.getLogger(EvaluateController.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;
    private final InvestCompositeIntegration investCompositeIntegration;
    private final String investmentUrl = "http://investment";

    @GetMapping(value = "evaluate/")
    public ResponseEntity<String> setEvaluate(@RequestParam Long companyIdx) {
        return restTemplate.getForEntity(investmentUrl + "/evaluate/?companyIdx={companyIdx}&vcCompanyIdx={vcCompanyIdx}", String.class, companyIdx, investCompositeIntegration.getUser().getCompanyIdx());
    }

    @GetMapping(value = "evaluate/list")
    public ResponseEntity<EvaluateListDTO> getEvaluateList() {
        return restTemplate.getForEntity(investmentUrl + "/evaluate/list?companyIdx={companyIdx}", EvaluateListDTO.class, investCompositeIntegration.getUser().getCompanyIdx());
    }

    @GetMapping(value = "evaluate/detail")
    public ResponseEntity<EvaluateDTO> getEvaluate(@RequestParam Long evaluateIdx) {
        return restTemplate.getForEntity(investmentUrl + "/evaluate/detail?evaluateIdx={evaluateIdx}", EvaluateDTO.class, evaluateIdx);
    }

    @PostMapping(value = "evaluate/edit")
    public ResponseEntity<String> editEvaluate(@RequestBody EvaluateDTO evaluateDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(investmentUrl + "/evaluate/edit", new HttpEntity(evaluateDTO, headers), String.class);
    }

    @PostMapping(value = "evaluate/delete")
    public ResponseEntity<String> deleteEvaluate(@RequestBody EvaluateDTO evaluateDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(investmentUrl + "/evaluate/delete", new HttpEntity(evaluateDTO, headers), String.class);
    }

    @PostMapping(value = "evaluate/judge")
    public ResponseEntity<String> editJudge(@RequestBody JudgeDTO judgeDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(investmentUrl + "/evaluate/judge", new HttpEntity(judgeDTO, headers), String.class);
    }

    @PostMapping(value = "evaluate/review")
    public ResponseEntity<String> editReviewItem(@RequestBody ReviewItemDTO reviewItemDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(investmentUrl + "/evaluate/review", new HttpEntity(reviewItemDTO, headers), String.class);
    }

}