package com.illunex.invest.startup.service.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.BusinessDTO;
import com.illunex.invest.api.core.company.dto.CompanyIdDTO;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BusinessIntegrationService extends DefaultIntegrationService {
    public BusinessIntegrationService(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public ResponseEntity<ResponseData> getBusiness() {
        BusinessDTO result = restTemplate.getForObject(companyUrl + "/business/" + getUser().getCompanyIdx()
                , BusinessDTO.class);
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(result)
                .build());
    }

    public ResponseEntity<ResponseData> editBusiness(BusinessDTO businessDTO) {
        businessDTO.setCompany(CompanyIdDTO.builder()
                .companyIdx(getUser().getCompanyIdx())
                .build());
        BusinessDTO result = restTemplate.postForObject(companyUrl + "/business"
                , new HttpEntity<>(businessDTO, getDefaultHeader())
                , BusinessDTO.class);
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(result)
                .build());
    }

    public String uploadImage(MultipartFile file) {
        ResponseEntity<ResponseData> uploadRes = fileUpload(file, bucket, "company/business/");

        return String.valueOf(uploadRes.getBody().getData());
    }
}
