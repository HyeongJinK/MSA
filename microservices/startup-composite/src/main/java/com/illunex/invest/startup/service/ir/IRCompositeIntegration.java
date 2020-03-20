package com.illunex.invest.startup.service.ir;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.communication.dto.MultiFileDeleteDTO;
import com.illunex.invest.api.core.ir.dto.ImgDTO;
import com.illunex.invest.startup.service.DefaultCompositeIntegration;
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
public class IRCompositeIntegration extends DefaultCompositeIntegration {
    Logger logger = LoggerFactory.getLogger(IRCompositeIntegration.class);

    public IRCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public String imgUpload(MultipartFile file, Long irIdx) {
        ResponseEntity<ResponseData> uploadRes = fileUpload(file, "invest-startup", "ir/member/");
        String imgUrl = String.valueOf(uploadRes.getBody().getData());

        ImgDTO imgDTO = ImgDTO.builder()
                .imgUrl(imgUrl)
                .irIdx(irIdx)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        restTemplate.postForEntity(irUrl + "/ir/img/temp", new HttpEntity(imgDTO, headers), String.class);

        return imgUrl;
    }

    public String imgDelete(ImgDTO imgDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        MultiFileDeleteDTO multiFileDeleteDTO = restTemplate.postForObject(irUrl + "/ir/img/delete", new HttpEntity(imgDTO, headers), MultiFileDeleteDTO.class);

        if (multiFileDeleteDTO.getBucket().equals("unavailable")) {
            return "Temp img does not exist";
        } else {
            return multiFileDelete(multiFileDeleteDTO).getBody();
        }
    }

}
