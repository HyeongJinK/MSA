package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.company.dto.ProductDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "상품 API")
@RequestMapping(value = "/product")
public interface ProductController {
    @ApiOperation(value = "회사번호로 상품 리스트 조회")
    @GetMapping("/list/{companyId}")
    ResponseEntity<List<ProductDTO>> getProductList(@PathVariable Long companyId);

    @ApiOperation(value = "회사번호로 상품 페이지 조회")
    @GetMapping("/page/{companyId}")
    ResponseEntity<Page<ProductDTO>> getProductPage(@PathVariable Long companyId);

    @ApiOperation(value = "상품 편집")
    @PostMapping("/")
    ResponseEntity<ResponseData> addProduct(@RequestBody ProductDTO productDTO);
    @ApiOperation(value = "상품 하나 조회")
    @GetMapping("/{productId}")
    ResponseEntity<ProductDTO> readProduct(@PathVariable Long productId);
    @ApiOperation(value = "상품 삭제")
    @DeleteMapping("/{productId}")
    ResponseEntity<ResponseData> deleteProduct(@PathVariable Long productId);



}
