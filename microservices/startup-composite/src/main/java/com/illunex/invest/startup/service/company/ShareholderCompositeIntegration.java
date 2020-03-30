package com.illunex.invest.startup.service.company;


import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.ShareholderDTO;
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
public class ShareholderCompositeIntegration extends DefaultIntegrationService {
    public ShareholderCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public ShareholderDTO getShareholderDTO() {
        Long companyId = getUser().getCompanyIdx();
        ResponseEntity<ShareholderDTO> res = restTemplate.getForEntity(companyUrl + "/shareholder/" + companyId.toString()
                , ShareholderDTO.class);

        return res.getBody();
    }

    public void editShareholder(ShareholderDTO shareholderDTO) {
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
