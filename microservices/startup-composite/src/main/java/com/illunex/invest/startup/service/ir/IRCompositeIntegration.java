package com.illunex.invest.startup.service.ir;

import com.google.gson.Gson;
import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.communication.model.SignUpMailRequest;
import com.illunex.invest.api.core.company.model.CompanyRegisterRequest;
import com.illunex.invest.api.core.ir.dto.ImgUploadDTO;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.exception.UsernameSearchEmptyException;
import com.illunex.invest.api.core.user.model.ChangePasswordRequest;
import com.illunex.invest.api.core.user.model.SignInRequest;
import com.illunex.invest.api.core.user.model.SignUpRequest;
import com.illunex.invest.api.core.user.model.SignatureRequest;
import com.illunex.invest.startup.service.DefaultCompositeIntegration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class IRCompositeIntegration extends DefaultCompositeIntegration {
    Logger logger = LoggerFactory.getLogger(IRCompositeIntegration.class);

    public IRCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public String imgUpload(MultipartFile file) {

        ResponseEntity<ResponseData> uploadRes = fileUpload(file, "invest-startup", "ir/member/");

        System.out.println("-----uploadRes------" + uploadRes.getBody().getData());

        return String.valueOf(uploadRes.getBody().getData());
    }

//
//    public ResponseEntity<ResponseData> signature(MultipartFile file) {
//
//        ResponseEntity<ResponseData> uploadRes = fileUpload(file, "invest-startup", "user/signature/");
//
//        return restTemplate.postForEntity(userUrl + "/signature/add", new HttpEntity<>(SignatureRequest.builder()
//                .imgUrl(String.valueOf(uploadRes.getBody().getData()))
//                .userId(getUser().getId())
//                .build()), ResponseData.class);
//    }
//
//    public ResponseEntity<ResponseList> signatureList() {
//        return restTemplate.getForEntity(userUrl + "/signature/list?userId="+getUser().getId(), ResponseList.class);
//    }
//
//    public ResponseEntity<ResponseData> signatureStatusToggle(Long id) {
//        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
//        map.add("id", id);
//
//        return restTemplate.exchange(userUrl + "/signature/toggle", HttpMethod.PUT, new HttpEntity<>(map, getDefaultHeader(MediaType.APPLICATION_FORM_URLENCODED)), ResponseData.class);
//    }
//
//    public ResponseEntity<ResponseData> signatureDelete(Long id) {
//        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
//
//        return restTemplate.exchange(userUrl + "/signature/delete?id="+id, HttpMethod.DELETE, new HttpEntity<>(map, getDefaultHeader(MediaType.APPLICATION_FORM_URLENCODED)), ResponseData.class);
//    }

}
