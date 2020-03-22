package com.illunex.invest.startup.controller.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.mypage.controller.PluginCompositeController;
import com.illunex.invest.api.core.shop.request.BuyProductRequest;
import com.illunex.invest.startup.controller.StartupDefaultController;
import com.illunex.invest.startup.service.mypage.PluginIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PluginCompositeControllerImpl extends StartupDefaultController implements PluginCompositeController {
    private final PluginIntegrationService pluginIntegrationService;

    @Override
    public ResponseEntity<ResponseList> getPlugins() {
        return pluginIntegrationService.getPlugins();
    }

    @Override
    public ResponseEntity<ResponseData> purchase(BuyProductRequest product) {
        return pluginIntegrationService.purchase(product);
    }
}
