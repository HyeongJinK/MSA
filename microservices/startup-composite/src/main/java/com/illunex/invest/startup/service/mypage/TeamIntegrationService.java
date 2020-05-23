package com.illunex.invest.startup.service.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TeamIntegrationService extends DefaultIntegrationService {
    public TeamIntegrationService(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public ResponseEntity<ResponseList> getMembers() {
        return restTemplate.getForEntity(userUrl + "/member?companyIdx="+getUser().getCompanyIdx(), ResponseList.class);
    }

    public ResponseEntity<ResponseData> deleteMember(Long id) {
        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
        map.add("id", id);

        return restTemplate.exchange(userUrl+"/member", HttpMethod.DELETE, new HttpEntity<>(map, getDefaultHeader(MediaType.APPLICATION_FORM_URLENCODED)), ResponseData.class);
    }
}
