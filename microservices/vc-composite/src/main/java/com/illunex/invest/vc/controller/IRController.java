package com.illunex.invest.vc.controller;

import com.illunex.invest.api.core.ir.dto.*;
import com.illunex.invest.vc.service.investment.InvestCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
public class IRController {
    Logger logger = LoggerFactory.getLogger(IRController.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;
    private final InvestCompositeIntegration investCompositeIntegration;
    private final String irUrl = "http://ir";

    @GetMapping(value = "ir/")
    public ResponseEntity<IRDTO> getIR(@RequestParam Long companyIdx) {
        return restTemplate.getForEntity(irUrl + "/vc/?companyIdx={companyIdx}", IRDTO.class, companyIdx);
    }

    @GetMapping(value = "ir/basicInfo")
    public ResponseEntity<BasicInfoDTO> getBasicInfo(@RequestParam Long companyIdx) {
        return restTemplate.getForEntity(irUrl + "/vc/basicInfo?companyIdx={companyIdx}", BasicInfoDTO.class, companyIdx);
    }

    @GetMapping(value = "ir/finance")
    public ResponseEntity<FinanceDTO> getFinanceInfo(@RequestParam Long companyIdx) {
        return restTemplate.getForEntity(irUrl + "/vc/finance?companyIdx={companyIdx}", FinanceDTO.class, companyIdx);
    }

    @GetMapping(value = "ir/history")
    public ResponseEntity<ListDTO> getHistoryList(@RequestParam Long companyIdx) {
        return restTemplate.getForEntity(irUrl + "/vc/history?companyIdx={companyIdx}", ListDTO.class, companyIdx);
    }

    @GetMapping(value = "ir/member")
    public ResponseEntity<ListDTO> getMemberList(@RequestParam Long companyIdx) {
        return restTemplate.getForEntity(irUrl + "/vc/member?companyIdx={companyIdx}", ListDTO.class, companyIdx);
    }

    @GetMapping(value = "ir/outcome")
    public ResponseEntity<OutcomeDTO> getOutcomeInfo(@RequestParam Long companyIdx) {
        return restTemplate.getForEntity(irUrl + "/vc/outcome?companyIdx={companyIdx}", OutcomeDTO.class, companyIdx);
    }

    @GetMapping(value = "ir/product")
    public ResponseEntity<ProductDTO> getProductInfo(@RequestParam Long companyIdx) {
        return restTemplate.getForEntity(irUrl + "/vc/product?companyIdx={companyIdx}", ProductDTO.class, companyIdx);
    }

    @GetMapping(value = "ir/shareholder")
    public ResponseEntity<ListDTO> getShareholderList(@RequestParam Long companyIdx) {
        return restTemplate.getForEntity(irUrl + "/vc/shareholder?companyIdx={companyIdx}", ListDTO.class, companyIdx);
    }
}