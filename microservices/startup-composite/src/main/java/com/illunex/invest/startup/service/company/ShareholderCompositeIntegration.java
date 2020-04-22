package com.illunex.invest.startup.service.company;


import com.illunex.invest.api.core.company.dto.CompanyIdDTO;
import com.illunex.invest.api.core.company.dto.ShareholderDTO;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Log
@Service
public class ShareholderCompositeIntegration extends DefaultIntegrationService {
    public ShareholderCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public List<ShareholderDTO> getShareholderDTOs() {
        Long companyId = getUser().getCompanyIdx();
        ResponseEntity<List> res = restTemplate.getForEntity(companyUrl + "/shareholder/" + companyId
                , List.class);
        return res.getBody();
    }

    public ShareholderDTO getShareholderDTO(Long id) {
        ResponseEntity<ShareholderDTO> res = restTemplate.getForEntity(companyUrl + "/shareholder/read/" + id
                , ShareholderDTO.class);
        log.info(res.getBody().toString());
        return res.getBody();
    }

    public void editShareholder(ShareholderDTO shareholderDTO) {
        shareholderDTO.setCompany(new CompanyIdDTO(getUser().getCompanyIdx()));
        restTemplate.postForEntity(companyUrl+ "/shareholder"
                , new HttpEntity<>(shareholderDTO, getDefaultHeader())
                , String.class);
    }

    public void deleteShareholder(Long id) {
        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
        restTemplate.exchange(userUrl + "/shareholder/"+ id
                , HttpMethod.DELETE
                , new HttpEntity<>(map
                        , getDefaultHeader(MediaType.APPLICATION_FORM_URLENCODED))
                , String.class);
    }
}
