package com.illunex.invest.vc.service.investment;

import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.company.dto.VcCompanyDTO;
import com.illunex.invest.api.core.investment.dto.DealSourcingDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateStateDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateStateListDTO;
import com.illunex.invest.vc.service.DefaultIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class DealSourcingCompositeIntegration extends DefaultIntegrationService {
    Logger logger = LoggerFactory.getLogger(DealSourcingCompositeIntegration.class);

    public DealSourcingCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    private final String investmentUrl = "http://investment";
    private final String companyUrl = "http://company";

    public DealSourcingDTO getDealSourcingList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseList companyList =  restTemplate.getForEntity(companyUrl + "/company/vc", ResponseList.class).getBody();
        List<VcCompanyDTO> companyDTOList = companyList.getData();

        EvaluateStateListDTO evaluateStateListDTO = restTemplate.getForEntity(investmentUrl + "/evaluate/list/state?companyIdx={companyIdx}", EvaluateStateListDTO.class, getUser().getCompanyIdx()).getBody();
        List<EvaluateStateDTO> evaluateList = evaluateStateListDTO.getEvaluateState();

        return DealSourcingDTO.builder()
                .companyList(companyDTOList)
                .evaluateStateList(evaluateList)
                .build();
    }

}
