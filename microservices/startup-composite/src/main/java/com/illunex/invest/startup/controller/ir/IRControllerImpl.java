package com.illunex.invest.startup.controller.ir;

import com.illunex.invest.api.core.ir.controller.IRController;
import com.illunex.invest.api.core.ir.dto.IRDTO;
import com.illunex.invest.api.core.ir.dto.IRListDTO;
import com.illunex.invest.api.core.ir.dto.PasswordDTO;
import com.illunex.invest.api.core.board.controller.BoardController;
import com.illunex.invest.api.core.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class IRControllerImpl implements IRController {
    Logger logger = LoggerFactory.getLogger(IRControllerImpl.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;

    private final String irUrl = "http://ir";

    @Override
    public ResponseEntity<IRListDTO> getIRList(Long companyIdx) {
        return restTemplate.getForEntity(irUrl + "/ir/list?companyIdx={companyIdx}", IRListDTO.class, companyIdx);
    }

    @Override
    public ResponseEntity<String> changeCardColor(IRDTO irdto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/color", new HttpEntity(irdto, headers), String.class);
    }

    @Override
    public ResponseEntity<String> setPassword(PasswordDTO passwordDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/pw/set", new HttpEntity(passwordDTO, headers), String.class);
    }

    @Override
    public ResponseEntity<String> resetPassword(PasswordDTO passwordDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/pw/reset", new HttpEntity(passwordDTO, headers), String.class);
    }

    @Override
    public ResponseEntity<String> confirmPassword(PasswordDTO passwordDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/pw/confirm", new HttpEntity(passwordDTO, headers), String.class);
    }

    @Override
    public ResponseEntity<String> changePassword(PasswordDTO passwordDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/pw/change", new HttpEntity(passwordDTO, headers), String.class);
    }
}