package com.illunex.invest.startup.controller.company;

import com.illunex.invest.api.composite.startup.company.controller.CompanyCompositeController;
import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.startup.service.company.CompanyCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyCompositeControllerImpl implements CompanyCompositeController {
    private final CompanyCompositeIntegration companyCompositeIntegration;

    @Override
    public ResponseEntity<List<ProductDTO>> productList() {
        return new ResponseEntity<>(companyCompositeIntegration.getProductList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> editProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDTO> readProduct(Long productId) {
        return null;
    }
}
