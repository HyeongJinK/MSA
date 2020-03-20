package com.illunex.invest.startup.controller.shop;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.shop.controller.PluginProductCompositeController;
import com.illunex.invest.api.core.shop.request.BuyProductRequest;
import com.illunex.invest.startup.service.shop.PluginProductCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PluginProductCompositeControllerImpl implements PluginProductCompositeController {
    private final PluginProductCompositeIntegration pluginProductCompositeIntegration;

    @Override
    public ResponseEntity<ResponseList> getPlugins() {
        return pluginProductCompositeIntegration.getPlugins();
    }

    @Override
    public ResponseEntity<ResponseData> purchase(BuyProductRequest product) {
        return pluginProductCompositeIntegration.purchase(product);
    }
}
