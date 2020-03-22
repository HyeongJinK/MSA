package com.illunex.invest.api.core.shop.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.shop.dto.ProductDTO;
import com.illunex.invest.api.core.shop.dto.PurchaseDTO;
import com.illunex.invest.api.core.shop.request.PurchaseRequest;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "플러그인 조회, 설치")
@RequestMapping("/product")
public interface ProductController {
    // 플러그인 목록 (판매중인 목록, 회사 번호(라이센스 체크))
    @GetMapping("/plugin/{companyIdx}")
    ResponseEntity<ResponseList<ProductDTO>> getPlugins(@PathVariable("companyIdx") Long companyIdx);
    // 플러그인 설치
    @PostMapping("/purchase")
    ResponseEntity<ResponseData<PurchaseDTO>> purchase(@RequestBody PurchaseRequest purchaseRequest);
}
