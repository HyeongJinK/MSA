package com.illunex.invest.vc.controller;

import com.illunex.invest.api.core.investment.dto.DealSourcingDTO;
import com.illunex.invest.vc.service.investment.RoundCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
public class RoundController {
    Logger logger = LoggerFactory.getLogger(RoundController.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;
    private final RoundCompositeIntegration roundCompositeIntegration;

    @GetMapping(value = "round/result")
    public ResponseEntity<DealSourcingDTO> getRoundResult(@RequestParam Long roundIdx) {
        return new ResponseEntity(roundCompositeIntegration.getRoundResult(roundIdx), HttpStatus.OK);
    }

}