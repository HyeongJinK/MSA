package com.illunex.invest.startup.service;

import com.illunex.invest.api.common.exception.FileUploadException;
import com.illunex.invest.api.common.request.MultipartInputStreamFileResource;
import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@RequiredArgsConstructor
public class DefaultCompositeIntegration {
    protected final RestTemplate restTemplate;
    protected final WebClient.Builder loadBalanceWebClientBuilder;
    protected final String userUrl = "http://user";
    protected final String companyUrl = "http://company";
    protected final String communicationUrl = "http://communication";
    protected final String startUpUrl = "https://startup.effectmall.com";

    protected UserDTO getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null) {
            UserDTO userDetails = (UserDTO) principal;

            return userDetails;
        }
        else {
            return null;
        }
    }

    @NotNull
    protected HttpHeaders getDefaultHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @NotNull
    protected ResponseEntity<ResponseData> fileUpload(MultipartFile file, String bucket, String path) {
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();

        try {
            map.add("bucket", bucket);
            map.add("path", path);
            map.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename(), file.getSize()));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);

            return restTemplate.postForEntity(communicationUrl + "/file/upload", requestEntity, ResponseData.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileUploadException("파일 업로드 실패");
        }
    }
}
