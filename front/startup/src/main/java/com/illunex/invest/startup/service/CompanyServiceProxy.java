package com.illunex.invest.startup.service;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompanyServiceProxy {
    @Autowired
    RestTemplate restTemplate;

    private final String cmpanyUrl = "http://company";

    public CompanyDTO getCompanyByUserIdx(Long userIdx) {
        ResponseEntity<CompanyDTO> data = restTemplate.getForEntity(cmpanyUrl + "/company/user/1", CompanyDTO.class);
        return data.getBody();
    }
}
