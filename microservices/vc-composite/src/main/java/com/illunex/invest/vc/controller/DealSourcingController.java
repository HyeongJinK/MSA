package com.illunex.invest.vc.controller;

import com.illunex.invest.api.core.investment.dto.DealSourcingDTO;
import com.illunex.invest.vc.service.investment.DealSourcingCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
public class DealSourcingController {
    Logger logger = LoggerFactory.getLogger(DealSourcingController.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;
    private final DealSourcingCompositeIntegration dealSourcingCompositeIntegration;

    @GetMapping(value = "dealSourcing/list")
    public ResponseEntity<DealSourcingDTO> getDealSourcingList() {
        return new ResponseEntity(dealSourcingCompositeIntegration.getDealSourcingList(), HttpStatus.OK);
    }

}