package com.illunex.invest.vc.service;

import com.google.gson.Gson;
import com.illunex.invest.api.common.exception.ExpireUserException;
import com.illunex.invest.api.common.exception.FileUploadException;
import com.illunex.invest.api.common.request.MultipartInputStreamFileResource;
import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.communication.dto.MultiFileDeleteDTO;
import com.illunex.invest.api.core.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.Cacheable;
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
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DefaultIntegrationService {
    protected final RestTemplate restTemplate;
    protected final WebClient.Builder loadBalanceWebClientBuilder;
    protected final String userUrl = "http://user";
    protected final String irUrl = "http://ir";
    protected final String companyUrl = "http://company";
    protected final String communicationUrl = "http://communication";
    protected final String shopUrl = "http://shop";
    protected final String investUrl = "http://invest";
    protected final String startUpUrl = "https://startup.effectmall.com";

//    @Cacheable(value="user")
    public UserDTO getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null) {
            try {
            UserDTO userDetails = (UserDTO) principal;

            return userDetails;
            } catch (ClassCastException e) {
                throw new ExpireUserException("계정이 만료되었습니다.");
            }
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
    protected HttpHeaders getDefaultHeader(MediaType type) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(type);
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

    @NotNull
    protected ResponseEntity<String> multiFileDelete(MultiFileDeleteDTO multiFileDeleteDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return restTemplate.postForEntity(communicationUrl + "/file/multiFileDelete", new HttpEntity(multiFileDeleteDTO, headers), String.class);
    }

    protected List ListDTOParser(ResponseList res, Class c) {
        Gson gson = new Gson();
        ArrayList result = new ArrayList<>();
        if (res.getErrorCode() == 0) {
            List lists = res.getData();

            lists.stream().forEach(m -> {
                result.add(gson.fromJson(m.toString(), c));
            });
            return result;
        } else {
            return new ArrayList();
        }
    }
}
