package com.illunex.invest.startup.controller.ir;

import com.illunex.invest.api.core.ir.controller.FinanceController;
import com.illunex.invest.api.core.ir.dto.FinanceDTO;
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
public class FinanceControllerImpl implements FinanceController {
    Logger logger = LoggerFactory.getLogger(FinanceControllerImpl.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;

    private final String irUrl = "http://ir";

    @Override
    public ResponseEntity<FinanceDTO> getFinanceInfo(Long irIdx) {
        return restTemplate.getForEntity(irUrl + "/ir/finance?irIdx={irIdx}", FinanceDTO.class, irIdx);
    }

    @Override
    public ResponseEntity<String> editFinanceInfo(FinanceDTO financeDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/finance", new HttpEntity(financeDTO, headers), String.class);
    }
}