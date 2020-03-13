package com.illunex.invest.startup.service.user;

import com.google.gson.Gson;
import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.communication.model.SignUpMailRequest;
import com.illunex.invest.api.core.company.model.CompanyRegisterRequest;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.exception.UsernameSearchEmptyException;
import com.illunex.invest.api.core.user.model.ChangePasswordRequest;
import com.illunex.invest.api.core.user.model.SignInRequest;
import com.illunex.invest.api.core.user.model.SignUpRequest;
import com.illunex.invest.startup.service.DefaultCompositeIntegration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class UserCompositeIntegration extends DefaultCompositeIntegration {
    Logger logger = LoggerFactory.getLogger(UserCompositeIntegration.class);

    private final RestTemplate restTemplate;
    //private final WebClient.Builder loadBalanceWebClientBuilder;
    private final String userUrl = "http://user";
    private final String companyUrl = "http://company";
    private final String communicationUrl = "http://communication";
    private final String startUpUrl = "https://startup.effectmall.com";

    @HystrixCommand(fallbackMethod = "signInError")
    public UserDTO signIn(String username) {
        ResponseData res = restTemplate.postForObject(userUrl + "/signIn", new HttpEntity<>(new SignInRequest(username, ""), getDefaultHeader()), ResponseData.class);

        UserDTO user = UserDTOParser(res);

        if (user != null) {
            return user;
        } else {
            throw new UsernameSearchEmptyException("유저가 없습니다.");
        }
    }

    @HystrixCommand(fallbackMethod = "signUpError")
    public ResponseEntity<ResponseData> signUp(String username, String password, String name, String businessNumber, String vender) {
        // 회사 등록
        Long companyIdx = restTemplate.postForObject(companyUrl + "/company/register", new HttpEntity<>(new CompanyRegisterRequest(businessNumber), getDefaultHeader()), Long.class);
        // 사용자 추가
        ResponseData res = restTemplate.postForObject(userUrl + "/signUp", new HttpEntity<>(new SignUpRequest(username, password, name, vender, companyIdx), getDefaultHeader()), ResponseData.class);
        UserDTO user = UserDTOParser(res);
        //  인증 메일 보내기
        restTemplate.postForObject(communicationUrl + "/mail/signUp", new HttpEntity<>(new SignUpMailRequest(user.getUsername(), startUpUrl+"/user/register/confirm?token="+user.getToken()), getDefaultHeader()), String.class);

        // 결과 리턴
        return ResponseEntity.ok(res);
    }

    @HystrixCommand(fallbackMethod = "changePasswordError")
    public ResponseEntity<ResponseData> changePassword(String prePassword, String password) {
        return ResponseEntity.ok(restTemplate.postForObject(userUrl + "/changePassword"
                        , new HttpEntity<>(new ChangePasswordRequest(getUser().getUsername(), prePassword, password)
                                , getDefaultHeader())
                    , ResponseData.class));
    }

    public ResponseEntity<ResponseData> signature(MultipartFile file) {
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        try {
            map.add("file", new ByteArrayResource(file.getBytes()));
            map.add("fileName", file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
        return restTemplate.postForEntity(userUrl + "", requestEntity, ResponseData.class);
    }


    private UserDTO UserDTOParser(ResponseData res) {
        Gson gson = new Gson();
        if (res.getErrorCode() == 0) {
            return gson.fromJson(res.getData().toString(), UserDTO.class);
        } else {
            return null;
        }
    }

    public UserDTO signInError(String username) {
        throw new UsernameSearchEmptyException("통신에 장애가 있습니다.");
    }

    public ResponseEntity<ResponseData> signUpError(String username, String password, String name, String businessNumber, String vender) {
        throw new UsernameSearchEmptyException("통신에 장애가 있습니다.");
    }

    public ResponseEntity<ResponseData> changePasswordError(String prePassword, String password) {
        throw new UsernameSearchEmptyException("통신에 장애가 있습니다.");
    }
}
