package com.illunex.invest.startup.service.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.user.request.SignatureRequest;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SignatureIntegrationService extends DefaultIntegrationService {
    public SignatureIntegrationService(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public ResponseEntity<ResponseData> signature(MultipartFile file) {

        ResponseEntity<ResponseData> uploadRes = fileUpload(file, bucket, "user/signature/");

        return restTemplate.postForEntity(userUrl + "/signature/add", new HttpEntity<>(SignatureRequest.builder()
                .imgUrl(String.valueOf(uploadRes.getBody().getData()))
                .userId(getUser().getId())
                .build()), ResponseData.class);
    }

    public ResponseEntity<ResponseList> signatureList() {
        return restTemplate.getForEntity(userUrl + "/signature/list?userId="+getUser().getId(), ResponseList.class);
    }

    public ResponseEntity<ResponseData> signatureStatusToggle(Long id) {
        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
        map.add("id", id);

        return restTemplate.exchange(userUrl + "/signature/toggle", HttpMethod.PUT, new HttpEntity<>(map, getDefaultHeader(MediaType.APPLICATION_FORM_URLENCODED)), ResponseData.class);
    }

    public ResponseEntity<ResponseData> signatureDelete(Long id) {
        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();

        return restTemplate.exchange(userUrl + "/signature/delete?id="+id, HttpMethod.DELETE, new HttpEntity<>(map, getDefaultHeader(MediaType.APPLICATION_FORM_URLENCODED)), ResponseData.class);
    }

}
