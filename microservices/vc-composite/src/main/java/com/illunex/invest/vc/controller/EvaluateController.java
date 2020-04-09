package com.illunex.invest.vc.controller;

import com.illunex.invest.api.core.invest.dto.EvaluateDTO;
import com.illunex.invest.api.core.invest.dto.EvaluateListDTO;
import com.illunex.invest.vc.service.invest.InvestCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
public class EvaluateController {
    Logger logger = LoggerFactory.getLogger(EvaluateController.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;
    private final InvestCompositeIntegration investCompositeIntegration;
    private final String investUrl = "http://invest";

    @GetMapping(value = "evaluate/list")
    public ResponseEntity<EvaluateListDTO> getEvaluateList() {
        return restTemplate.getForEntity(investUrl + "/evaluate/list?companyIdx={companyIdx}", EvaluateListDTO.class, investCompositeIntegration.getUser().getCompanyIdx());
    }

    @GetMapping(value = "evaluate/detail")
    public ResponseEntity<EvaluateDTO> getEvaluate(@RequestParam Long evaluateIdx) {
        return restTemplate.getForEntity(investUrl + "/evaluate/detail?evaluateIdx={evaluateIdx}", EvaluateDTO.class, evaluateIdx);
    }

}