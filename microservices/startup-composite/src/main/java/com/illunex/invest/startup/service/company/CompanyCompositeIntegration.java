package com.illunex.invest.startup.service.company;

import com.illunex.invest.api.core.company.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CompanyCompositeIntegration {
    private final RestTemplate restTemplate;

    private final String companyUrl = "http://company";

    public void test() {
        ResponseEntity<HelperPage> data = restTemplate.getForEntity(companyUrl + "/product/page/1", HelperPage.class);

        List<ProductDTO> companyDTOList = data.getBody().getContent();
    }
}
