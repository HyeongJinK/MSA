package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.company.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/product")
public interface ProductController {
    @GetMapping("/list/{companyId}")
    ResponseEntity<ResponseList> getProductList(@PathVariable Long companyId);

    @GetMapping("/page/{companyId}")
    ResponseEntity<Page<ProductDTO>> getProductPage(@PathVariable Long companyId);

    @PostMapping("/form")
    ResponseEntity<ResponseData> addProduct(@RequestBody ProductDTO productDTO);

    @GetMapping("/read/{productId}")
    ResponseEntity<ResponseData> readProduct(@PathVariable Long productId);
}
