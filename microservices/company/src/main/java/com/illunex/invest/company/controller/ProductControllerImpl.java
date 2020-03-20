package com.illunex.invest.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.company.controller.ProductController;
import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.company.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    @Qualifier(value = "CompanyProductService")
    private final ProductService productService;

    @Override
    public ResponseEntity<ResponseList> getProductList(Long companyId) {
        return ResponseEntity.ok(new ResponseList(0, "success", productService.getProductByCompanyIdx(companyId)));
    }

    @Override
    public ResponseEntity<Page<ProductDTO>> getProductPage(Long companyId) {
        return new ResponseEntity<>(productService.getProductPageByCompanyIdx(companyId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseData> addProduct(ProductDTO productDTO) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(productService.edit(productDTO))
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> readProduct(Long productId) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(productService.read(productId))
                .build());
    }
}
