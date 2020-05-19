package com.illunex.invest.startup.controller.ir;

import com.illunex.invest.api.core.ir.dto.IRDTO;
import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.api.core.ir.dto.PasswordDTO;
import com.illunex.invest.api.core.ir.dto.SignatureDTO;
import com.illunex.invest.api.core.user.dto.AuthorityDTO;
import com.illunex.invest.startup.service.ir.IRCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
public class IRController {
    Logger logger = LoggerFactory.getLogger(IRController.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;
    private final IRCompositeIntegration irCompositeIntegration;
    private final String irUrl = "http://ir";
    protected final String userUrl = "http://user";

    @GetMapping(value = "ir/")
    public ResponseEntity<IRDTO> getIR(@RequestParam String year) {
        return restTemplate.getForEntity(irUrl + "/ir/?companyIdx={companyIdx}&year={year}", IRDTO.class, irCompositeIntegration.getUser().getCompanyIdx(), year);
    }

    @GetMapping(value = "ir/list")
    public ResponseEntity<ListDTO> getIRList() {
        return restTemplate.getForEntity(irUrl + "/ir/list?companyIdx={companyIdx}", ListDTO.class, irCompositeIntegration.getUser().getCompanyIdx());
    }

    @PostMapping(value = "ir/color")
    public ResponseEntity<String> changeCardColor(@RequestBody IRDTO irdto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/color", new HttpEntity(irdto, headers), String.class);
    }

    @PostMapping(value = "ir/signature")
    public ResponseEntity<String> changeSignature(@RequestBody SignatureDTO signatureDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/signature", new HttpEntity(signatureDTO, headers), String.class);
    }

    @PostMapping(value = "ir/pw/set")
    public ResponseEntity<String> setPassword(@RequestBody PasswordDTO passwordDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/pw/set", new HttpEntity(passwordDTO, headers), String.class);
    }

    @PostMapping(value = "ir/pw/reset")
    public ResponseEntity<String> resetPassword(@RequestBody PasswordDTO passwordDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/pw/reset", new HttpEntity(passwordDTO, headers), String.class);
    }

    @PostMapping(value = "ir/pw/confirm")
    public ResponseEntity<String> confirmPassword(@RequestBody PasswordDTO passwordDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/pw/confirm", new HttpEntity(passwordDTO, headers), String.class);
    }

    @PostMapping(value = "ir/pw/change")
    public ResponseEntity<String> changePassword(@RequestBody PasswordDTO passwordDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/pw/change", new HttpEntity(passwordDTO, headers), String.class);
    }

    @GetMapping(value = "ir/auth")
    public ResponseEntity<AuthorityDTO> getMemberAuth() {
        return restTemplate.getForEntity(userUrl+"/authority/ir?userIdx={userIdx}", AuthorityDTO.class, irCompositeIntegration.getUser().getId());
    }
}