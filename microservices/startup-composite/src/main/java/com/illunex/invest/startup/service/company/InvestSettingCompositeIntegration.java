package com.illunex.invest.startup.service.company;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.CompanyIdDTO;
import com.illunex.invest.api.core.company.dto.InvestSettingDTO;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class InvestSettingCompositeIntegration extends DefaultIntegrationService {
    public InvestSettingCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public InvestSettingDTO getInvestSetting() {
        return restTemplate.getForObject(companyUrl + "/investSetting?companyIdx=" + getUser().getCompanyIdx(), InvestSettingDTO.class);
    }

    public void editInvestSetting(InvestSettingDTO investSettingDTO) {
        investSettingDTO.setCompany(CompanyIdDTO.builder().companyIdx(getUser().getCompanyIdx()).build());
        restTemplate.postForEntity(companyUrl + "/investSetting"
                , new HttpEntity<>(investSettingDTO, getDefaultHeader())
                , ResponseData.class);
    }
}
