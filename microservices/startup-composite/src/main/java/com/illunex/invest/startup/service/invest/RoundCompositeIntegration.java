package com.illunex.invest.startup.service.invest;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.investment.dto.VQRoundDTO;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RoundCompositeIntegration extends DefaultIntegrationService {
    Logger logger = LoggerFactory.getLogger(RoundCompositeIntegration.class);
    private final String investmentUrl = "http://investment";

    public RoundCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public String VQRoundAnswer(VQRoundDTO vqRoundDTO, MultipartFile businessRegistrationFile, MultipartFile companyProfileFile) {

        ResponseEntity<ResponseData> businessRegistration = fileUpload(businessRegistrationFile, "invest-startup", "invest/round/"+vqRoundDTO.getRoundName()+"/"+vqRoundDTO.getCompany());
        ResponseEntity<ResponseData> companyProfile = fileUpload(companyProfileFile, "invest-startup", "invest/round/"+vqRoundDTO.getRoundName()+"/"+vqRoundDTO.getCompany());

        vqRoundDTO.setBusinessRegistrationFile(String.valueOf(businessRegistration.getBody().getData()));
        vqRoundDTO.setCompanyProfileFile(String.valueOf(companyProfile.getBody().getData()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return restTemplate.postForEntity(investmentUrl + "/round/answer", new HttpEntity(vqRoundDTO, headers), String.class).getBody();
    }
}
