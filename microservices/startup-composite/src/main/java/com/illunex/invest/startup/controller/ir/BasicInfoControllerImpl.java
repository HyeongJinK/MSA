package com.illunex.invest.startup.controller.ir;

import com.illunex.invest.api.core.ir.controller.BasicInfoController;
import com.illunex.invest.api.core.ir.dto.BasicInfoDTO;
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
public class BasicInfoControllerImpl implements BasicInfoController {
    Logger logger = LoggerFactory.getLogger(BasicInfoControllerImpl.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;

    private final String irUrl = "http://ir";

    @Override
    public ResponseEntity<BasicInfoDTO> getBasicInfo(Long irIdx) {
        return restTemplate.getForEntity(irUrl + "/ir/basicInfo?irIdx={irIdx}", BasicInfoDTO.class, irIdx);
    }

    @Override
    public ResponseEntity<String> editBasicInfo(BasicInfoDTO basicInfoDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/basicInfo", new HttpEntity(basicInfoDTO, headers), String.class);
    }
}