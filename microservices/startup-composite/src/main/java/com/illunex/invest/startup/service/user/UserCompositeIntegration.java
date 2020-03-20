package com.illunex.invest.startup.service.user;

import com.google.gson.Gson;
import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.communication.model.SignUpMailRequest;
import com.illunex.invest.api.core.company.request.CompanyRegisterRequest;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.exception.UsernameSearchEmptyException;
import com.illunex.invest.api.core.user.request.ChangePasswordRequest;
import com.illunex.invest.api.core.user.request.SignInRequest;
import com.illunex.invest.api.core.user.request.SignUpRequest;
import com.illunex.invest.api.core.user.request.SignatureRequest;
import com.illunex.invest.startup.service.DefaultCompositeIntegration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class UserCompositeIntegration extends DefaultCompositeIntegration {
    Logger logger = LoggerFactory.getLogger(UserCompositeIntegration.class);

    public UserCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }


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
        ResponseData<Long> companyRes = restTemplate.postForObject(companyUrl + "/company/register", new HttpEntity<>(new CompanyRegisterRequest(businessNumber), getDefaultHeader()), ResponseData.class);
        // 사용자 추가
        ResponseData res = restTemplate.postForObject(userUrl + "/signUp", new HttpEntity<>(new SignUpRequest(username, password, name, vender, companyRes.getData()), getDefaultHeader()), ResponseData.class);
        UserDTO user = UserDTOParser(res);
        //  인증 메일 보내기
        restTemplate.postForObject(communicationUrl + "/mail/signUp", new HttpEntity<>(new SignUpMailRequest(user.getUsername(), startUpUrl+"/user/register/confirm?token="+user.getToken()), getDefaultHeader()), String.class);

        // 결과 리턴
        return ResponseEntity.ok(res);
    }

    @HystrixCommand(fallbackMethod = "changePasswordError")
    public ResponseEntity<ResponseData> changePassword(String prePassword, String password) {
        return restTemplate.postForEntity(userUrl + "/changePassword"
                        , new HttpEntity<>(new ChangePasswordRequest(getUser().getUsername(), prePassword, password)
                                , getDefaultHeader())
                    , ResponseData.class);
    }

    public ResponseEntity<ResponseData> signature(MultipartFile file) {

        ResponseEntity<ResponseData> uploadRes = fileUpload(file, "invest-startup", "user/signature/");

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
