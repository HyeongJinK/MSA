package com.illunex.invest.startup.service.company;

import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCompositeIntegration extends DefaultIntegrationService {
    public ProductCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public List<ProductDTO> getProductList() {
        Long companyId = getUser().getCompanyIdx();
        ResponseEntity<ArrayList> res = restTemplate.getForEntity(companyUrl + "/product/list/" + companyId.toString(), ArrayList.class);

        return res.getBody();
    }

    public ProductDTO getProduct(Long productIdx) {
        Long companyId = getUser().getCompanyIdx();
        ResponseEntity<ProductDTO> res = restTemplate.getForEntity(companyUrl + "/product/" + productIdx.toString(), ProductDTO.class);

        ProductDTO product = res.getBody();
        if (companyId != product.getCompany().getCompanyIdx()) {
            // TODO 상품 볼 권한이 없음 처리
        }

        return product;
    }

    public ProductDTO editProduct(ProductDTO productDTO) {
        Long companyId = getUser().getCompanyIdx();
        if (companyId != productDTO.getCompany().getCompanyIdx()) {
            // TODO 수정할 권한이 없음
        }


        return null;
    }
}
