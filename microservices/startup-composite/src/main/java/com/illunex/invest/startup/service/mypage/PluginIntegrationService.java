package com.illunex.invest.startup.service.mypage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.company.dto.PluginDTO;
import com.illunex.invest.api.core.company.dto.enumable.PluginState;
import com.illunex.invest.api.core.company.request.PluginRequest;
import com.illunex.invest.api.core.shop.dto.PurchaseDTO;
import com.illunex.invest.api.core.shop.request.BuyProductRequest;
import com.illunex.invest.api.core.shop.request.PurchaseRequest;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.request.PurchaseRoleRequest;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PluginIntegrationService extends DefaultIntegrationService {
    public PluginIntegrationService(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public List<HashMap> getPlugins() {
        // 회사에서 적용한 플러그인 리스트
        ResponseEntity<ResponseList> pluginsRes = restTemplate.getForEntity(companyUrl + "/plugin/"+ getUser().getCompanyIdx()
                , ResponseList.class);
        List<PluginDTO> plugins =ListDTOParser(pluginsRes.getBody(), PluginDTO.class);

        List<Long> ids = plugins.stream()
                .filter(pluginDTO -> pluginDTO.getState().equals(PluginState.OPEN))
                .map(PluginDTO::getProductId)
                .collect(Collectors.toList());
        // 판매중인 플러그인 목록
        ResponseEntity<ResponseList> pluginRes = restTemplate.getForEntity(shopUrl + "/product/plugin/"+getUser().getCompanyIdx()
                , ResponseList.class);
        List<HashMap<String, Object>> products = pluginRes.getBody().getData();

        return products.stream()
                .map((product) -> {
                    for (Long id: ids) {
                        if (Long.parseLong(product.get("id").toString()) == id) {
                            product.put("installed", true);
                            return product;
                        }
                    }
                    return product;
                })
                .collect(Collectors.toList());
    }

    public ResponseEntity<ResponseData> purchase(BuyProductRequest request) {
        UserDTO user = getUser();
        List<BuyProductRequest> list = new ArrayList<>();
        list.add(request);

        ResponseEntity<ResponseData> purchaseRes = restTemplate.postForEntity(shopUrl + "/product/purchase"
                , new HttpEntity<>(new PurchaseRequest(user.getId(), list), getDefaultHeader())
                , ResponseData.class);

        if (purchaseRes.getBody().getErrorCode() == 0) {    // 구매에 성공했을 경우
            // 회사쪽에 플러그인 상태 추가
            PurchaseDTO purchaseDTO = purchaseDTOParser(purchaseRes.getBody());

            restTemplate.postForEntity(companyUrl + "/plugin"
                    , new HttpEntity<>(new PluginRequest(purchaseDTO.getIds(), LocalDateTime.now(),  user.getCompanyIdx()), getDefaultHeader())
                    , ResponseData.class);

            // 권한추가
            System.out.println(purchaseDTO.getRoles().size());
            restTemplate.postForEntity(userUrl + "/authority/setRole"
                    , new HttpEntity<>(new PurchaseRoleRequest(user.getId(), purchaseDTO.getRoles()), getDefaultHeader())
                    , ResponseData.class);
        }

       return purchaseRes;
    }

    private PurchaseDTO purchaseDTOParser(ResponseData res) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class
                , (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) -> LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)).create();

        if (res.getErrorCode() == 0) {
            return gson.fromJson(res.getData().toString(), PurchaseDTO.class);
        } else {
            return null;
        }
    }
}
