package com.illunex.invest.api.composite.startup.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.company.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/company/product")
public interface ProductCompositeController {
    @GetMapping(value = {"", "/", "/list"})
    ResponseEntity<ResponseList> productList();
    @PostMapping(value = "/form")
    ResponseEntity<ResponseData> editProduct(@RequestBody ProductDTO productDTO);
    @GetMapping(value = "/{productId}")
    ResponseEntity<ResponseData> readProduct(@PathVariable Long productId);
    @DeleteMapping(value = "/{productId}")
    ResponseEntity<ResponseData> deleteProduct(@PathVariable Long productId);
}
