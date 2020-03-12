package com.illunex.invest.startup.service.company;

import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.startup.service.DefaultCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompanyCompositeIntegration extends DefaultCompositeIntegration {
    private final RestTemplate restTemplate;

    private final String companyUrl = "http://company";

//    public void test() {
//        ResponseEntity<HelperPage> data = restTemplate.getForEntity(companyUrl + "/product/page/1", HelperPage.class);
//
//        List<ProductDTO> companyDTOList = data.getBody().getContent();
//    }

    public List<ProductDTO> getProductList() {
        Long companyId = getUser().getCompanyIdx();
        ResponseEntity<ArrayList> res = restTemplate.getForEntity(companyUrl + "/product/list/" + companyId.toString(), ArrayList.class);

        return res.getBody();
    }

    public ProductDTO getProduct(Long productIdx) {
        Long companyId = getUser().getCompanyIdx();
        ResponseEntity<ProductDTO> res = restTemplate.getForEntity(companyUrl + "/product/read/" + productIdx.toString(), ProductDTO.class);

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
