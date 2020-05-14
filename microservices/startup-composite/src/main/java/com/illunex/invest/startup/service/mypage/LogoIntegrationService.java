package com.illunex.invest.startup.service.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.LogoDTO;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class LogoIntegrationService extends DefaultIntegrationService {
    public LogoIntegrationService(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public ResponseEntity<LogoDTO> getLogo() {

        return restTemplate.getForEntity(companyUrl + "/company/logo?companyIdx="+getUser().getCompanyIdx(), LogoDTO.class);
    }

    public ResponseEntity<ResponseData> updateLogo(LogoDTO logoDTO) {
        return restTemplate.postForEntity(companyUrl + "/company/logo"
                , new HttpEntity<>(logoDTO, getDefaultHeader())
                , ResponseData.class);
    }
}
