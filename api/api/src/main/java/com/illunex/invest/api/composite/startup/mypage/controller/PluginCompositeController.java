package com.illunex.invest.api.composite.startup.mypage.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.shop.request.BuyProductRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "마이페이지 플러그인")
@RequestMapping(value = "/myPage/plugin")
public interface PluginCompositeController {
    @ApiOperation(value = "조회")
    @GetMapping(value = {"", "/"})
    ResponseEntity<ResponseData> getPlugins();
    @ApiOperation(value = "구매")
    @PostMapping(value = {"", "/"})
    ResponseEntity<ResponseData> purchase(@RequestBody BuyProductRequest request);
}
