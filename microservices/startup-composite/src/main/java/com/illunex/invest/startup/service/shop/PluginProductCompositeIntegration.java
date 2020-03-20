package com.illunex.invest.startup.service.shop;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.shop.request.BuyProductRequest;
import com.illunex.invest.api.core.shop.request.PurchaseRequest;
import com.illunex.invest.startup.service.DefaultCompositeIntegration;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Component
public class PluginProductCompositeIntegration extends DefaultCompositeIntegration {
    public PluginProductCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public ResponseEntity<ResponseList> getPlugins() {
        return restTemplate.getForEntity(shopUrl + "/product/plugin/"+getUser().getCompanyIdx()
                , ResponseList.class);
    }

    public ResponseEntity<ResponseData> purchase(BuyProductRequest request) {
        List<BuyProductRequest> list = new ArrayList<>();
        list.add(request);
        return restTemplate.postForEntity(shopUrl + "/product/purchase"
                , new HttpEntity<>(new PurchaseRequest(getUser().getId(), list), getDefaultHeader())
                , ResponseData.class);
    }
}
