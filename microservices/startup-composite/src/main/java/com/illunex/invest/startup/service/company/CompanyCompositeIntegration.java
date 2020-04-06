package com.illunex.invest.startup.service.company;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

@Log
@Component
public class CompanyCompositeIntegration extends DefaultIntegrationService {
    public CompanyCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public CompanyDTO getCompanyInfo() {
        ResponseEntity<CompanyDTO> data = restTemplate.getForEntity(companyUrl + "/company/read/"+ getUser().getCompanyIdx()
                , CompanyDTO.class);
        log.info(data.getBody().toString());
        return data.getBody();
    }

    public void editCompany(CompanyDTO companyDTO) {
        companyDTO.setCompanyIdx(getUser().getCompanyIdx());
        log.info(companyDTO.toString());
        restTemplate.postForEntity(companyUrl + "/company/form/"
                , new HttpEntity<>(companyDTO, getDefaultHeader())
                , ResponseData.class);
    }

    public String uploadLogo(MultipartFile file) {
        ResponseEntity<ResponseData> uploadRes = fileUpload(file, bucket, "company/logo/");

        return String.valueOf(uploadRes.getBody().getData());
    }

}
