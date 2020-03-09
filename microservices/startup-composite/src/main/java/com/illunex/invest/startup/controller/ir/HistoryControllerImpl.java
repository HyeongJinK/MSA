package com.illunex.invest.startup.controller.ir;

import com.illunex.invest.api.core.ir.controller.HistoryController;
import com.illunex.invest.api.core.ir.dto.EditDTO;
import com.illunex.invest.api.core.ir.dto.ListDTO;
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
public class HistoryControllerImpl implements HistoryController {
    Logger logger = LoggerFactory.getLogger(HistoryControllerImpl.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;

    private final String irUrl = "http://ir";

    @Override
    public ResponseEntity<ListDTO> getHistoryList(Long irIdx) {
        return restTemplate.getForEntity(irUrl + "/ir/history?irIdx={irIdx}", ListDTO.class, irIdx);
    }

    @Override
    public ResponseEntity<String> editHistoryList(EditDTO editDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/history", new HttpEntity(editDTO, headers), String.class);
    }
}