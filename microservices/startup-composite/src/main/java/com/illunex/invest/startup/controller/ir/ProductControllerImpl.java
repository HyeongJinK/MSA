package com.illunex.invest.startup.controller.ir;

import com.illunex.invest.api.core.ir.controller.ProductController;
import com.illunex.invest.api.core.ir.dto.ProductDTO;
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
public class ProductControllerImpl implements ProductController {
    Logger logger = LoggerFactory.getLogger(ProductControllerImpl.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;

    private final String irUrl = "http://ir";

    @Override
    public ResponseEntity<ProductDTO> getProductInfo(Long irIdx) {
        return restTemplate.getForEntity(irUrl + "/ir/product?irIdx={irIdx}", ProductDTO.class, irIdx);
    }

    @Override
    public ResponseEntity<String> editProductInfo(ProductDTO productDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(irUrl + "/ir/product", new HttpEntity(productDTO, headers), String.class);
    }
}