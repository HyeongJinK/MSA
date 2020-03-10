package com.illunex.invest.api.composite.startup.company.controller;

import com.illunex.invest.api.core.company.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/company")
public interface CompanyCompositeController {
    @GetMapping(value = "/product/list")
    ResponseEntity<List<ProductDTO>> productList();
    @PostMapping(value = "/product/form")
    ResponseEntity<ProductDTO> editProduct(ProductDTO productDTO);
}
