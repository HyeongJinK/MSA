package com.illunex.invest.company.controller;

import com.illunex.invest.api.core.company.controller.ProductController;
import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.company.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    @Qualifier(value = "CompanyProductService")
    private final ProductService productService;

    @Override
    public ResponseEntity<List<ProductDTO>> getProductList(Long companyId) {
        return new ResponseEntity<>(productService.getProductByCompanyIdx(companyId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<ProductDTO>> getProductPage(Long companyId) {
        return new ResponseEntity<>(productService.getProductPageByCompanyIdx(companyId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> addProduct(ProductDTO productDTO) {
        return new ResponseEntity<>(productService.edit(productDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> readProduct(Long productId) {
        return new ResponseEntity<>(productService.read(productId), HttpStatus.OK);
    }
}
