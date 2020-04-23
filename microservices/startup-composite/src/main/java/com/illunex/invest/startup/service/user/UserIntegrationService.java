package com.illunex.invest.startup.service.user;

import com.google.gson.Gson;
import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.communication.model.SignUpMailRequest;
import com.illunex.invest.api.core.company.request.CompanyRegisterRequest;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.dto.UserInfoDTO;
import com.illunex.invest.api.core.user.exception.UsernameSearchEmptyException;
import com.illunex.invest.api.core.user.request.SignInRequest;
import com.illunex.invest.api.core.user.request.SignUpRequest;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserIntegrationService extends DefaultIntegrationService {
    Logger logger = LoggerFactory.getLogger(UserIntegrationService.class);

    public UserIntegrationService(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    //@HystrixCommand(fallbackMethod = "signInError")
    public UserDTO signIn(String username) {
        ResponseData res = restTemplate.postForObject(userUrl + "/signIn", new HttpEntity<>(new SignInRequest(username, ""), getDefaultHeader()), ResponseData.class);

        UserDTO user = userDTOParser(res);

        if (user != null) {
            return user;
        } else {
            throw new UsernameSearchEmptyException("유저가 없습니다.");
        }
    }

    //@HystrixCommand(fallbackMethod = "signUpError")
    public ResponseEntity<ResponseData> signUp(String username, String password, String name, String businessNumber, String vender) {
        // 회사 등록
        ResponseData companyRes = restTemplate.postForObject(companyUrl + "/company/register", new HttpEntity<>(new CompanyRegisterRequest(businessNumber), getDefaultHeader()), ResponseData.class);
        Long companyIdx = Long.parseLong(String.valueOf(companyRes.getData()));
        // 사용자 추가
        ResponseData res = restTemplate.postForObject(userUrl + "/signUp"
                , new HttpEntity<>(new SignUpRequest(username
                        , password
                        , name
                        , vender
                        , companyIdx)
                        , getDefaultHeader())
                , ResponseData.class);
        UserInfoDTO user = UserInfoDTOParser(res);
        //  인증 메일 보내기
        restTemplate.postForObject(communicationUrl + "/mail/signUp", new HttpEntity<>(new SignUpMailRequest(user.getUsername(), startUpUrl+"/user/register/confirm?token="+user.getToken()), getDefaultHeader()), String.class);

        // 결과 리턴
        return ResponseEntity.ok(res);
    }

    public ResponseEntity<ResponseData> invite(String username, String password, String name, String vender) {
        Long companyIdx = getUser().getCompanyIdx();
        // 사용자 추가
        ResponseData res = restTemplate.postForObject(userUrl + "/invite"
                , new HttpEntity<>(new SignUpRequest(username
                        , password
                        , name
                        , vender
                        , companyIdx)
                        , getDefaultHeader())
                , ResponseData.class);
        UserInfoDTO user = UserInfoDTOParser(res);
        //  인증 메일 보내기
        restTemplate.postForObject(communicationUrl + "/mail/signUp", new HttpEntity<>(new SignUpMailRequest(user.getUsername(), startUpUrl+"/user/register/confirm?token="+user.getToken()), getDefaultHeader()), String.class);

        return ResponseEntity.ok(res);
    }

    private UserInfoDTO UserInfoDTOParser(ResponseData res) {
        Gson gson = new Gson();
        if (res.getErrorCode() == 0) {
            return gson.fromJson(res.getData().toString(), UserInfoDTO.class);
        } else {
            return null;
        }
    }

    private UserDTO userDTOParser(ResponseData res) {
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
}
