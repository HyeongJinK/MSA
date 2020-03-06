package com.illunex.invest.api.core.shop.controller;

import com.illunex.invest.api.core.shop.model.PurchaseRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


public interface PlugInController {
    // TODO 플러그인 목록 (판매중인 목록, 유번(구매&활성&비활성 체크))

    // TODO 플러그인 설치
    @PostMapping("/purchase")
    ResponseEntity<String> purchase(PurchaseRequest purchaseRequest);
    // TODO 플러그인 활성화&비활성화
    // TODO 플러그인 목록 (유번으로 조회)
}
