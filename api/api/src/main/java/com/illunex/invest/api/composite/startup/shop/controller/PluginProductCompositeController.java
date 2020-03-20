package com.illunex.invest.api.composite.startup.shop.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.shop.request.BuyProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/shop/plugin")
public interface PluginProductCompositeController {
    @GetMapping(value = {"", "/"})
    ResponseEntity<ResponseList> getPlugins();
    @PostMapping(value = {"", ""})
    ResponseEntity<ResponseData> purchase(@RequestBody BuyProductRequest request);
}
