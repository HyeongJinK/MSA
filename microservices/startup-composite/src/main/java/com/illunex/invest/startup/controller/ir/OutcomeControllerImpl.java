package com.illunex.invest.startup.controller.ir;

import com.illunex.invest.api.core.ir.controller.OutcomeController;
import com.illunex.invest.api.core.ir.dto.FinanceDTO;
import com.illunex.invest.api.core.ir.dto.OutcomeDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
public class OutcomeControllerImpl implements OutcomeController {
    Logger logger = LoggerFactory.getLogger(OutcomeControllerImpl.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;

    private final String irUrl = "http://ir";

    @Override
    public ResponseEntity<OutcomeDTO> getOutcomeInfo(Long irIdx) {
        return restTemplate.getForEntity(irUrl + "/ir/outcome?irIdx={irIdx}", OutcomeDTO.class, irIdx);
    }

    @Override
    public ResponseEntity<String> editOutcomeInfo(OutcomeDTO outcomeDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/outcome", new HttpEntity(outcomeDTO, headers), String.class);
    }
}