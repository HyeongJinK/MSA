package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.core.company.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/product")
public interface ProductController {
    @GetMapping("/list/{companyId}")
    ResponseEntity<List<ProductDTO>> getProductList(@PathVariable Long companyId);

    @PostMapping("/form")
    ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO);

    @GetMapping("/read/{productId}")
    ResponseEntity<ProductDTO> readProduct(@PathVariable Long productId);
}
