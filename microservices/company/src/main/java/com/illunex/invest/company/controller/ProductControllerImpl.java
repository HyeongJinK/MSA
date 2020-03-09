package com.illunex.invest.company.controller;

import com.illunex.invest.api.core.company.controller.ProductController;
import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.company.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;

    @Override
    public ResponseEntity<List<ProductDTO>> getProductList(Long companyId) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDTO> addProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDTO> readProduct(Long productId) {
        return null;
    }
}
