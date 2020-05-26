package com.illunex.invest.startup.service.user;

import com.google.gson.Gson;
import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.user.request.InviteRequest;
import com.illunex.invest.api.core.communication.dto.AlarmMessageDTO;
import com.illunex.invest.api.core.communication.model.AddAlarmRequest;
import com.illunex.invest.api.core.communication.model.SignUpMailRequest;
import com.illunex.invest.api.core.company.request.CompanyRegisterRequest;
import com.illunex.invest.api.core.shop.request.BuyProductRequest;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.dto.UserInfoDTO;
import com.illunex.invest.api.core.user.exception.UsernameSearchEmptyException;
import com.illunex.invest.api.core.user.request.SignInRequest;
import com.illunex.invest.api.core.user.request.SignUpRequest;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import com.illunex.invest.startup.service.mypage.PluginIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserIntegrationService extends DefaultIntegrationService {
    Logger logger = LoggerFactory.getLogger(UserIntegrationService.class);
    private final PluginIntegrationService pluginIntegrationService;

    public UserIntegrationService(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder, PluginIntegrationService pluginIntegrationService) {
        super(restTemplate, loadBalanceWebClientBuilder);
        this.pluginIntegrationService = pluginIntegrationService;
    }

    //@HystrixCommand(fallbackMethod = "signInError")
    public UserDTO signIn(String username) {
        UserDTO user = restTemplate.postForObject(userUrl + "/signIn", new HttpEntity<>(new SignInRequest(username, ""), getDefaultHeader()), UserDTO.class);

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
        if (res.getErrorCode() != 0) {
            throw new UsernameNotFoundException(res.getMessage());
        }

        UserInfoDTO user = UserInfoDTOParser(res);
        // 인증 메일 보내기
        restTemplate.postForObject(communicationUrl + "/mail/signUp", new HttpEntity<>(new SignUpMailRequest(user.getUsername(), startUpUrl+"/user/register/confirm?token="+user.getToken()), getDefaultHeader()), String.class);
        // 기본 플러그인 적용하기
        List<BuyProductRequest> list = new ArrayList<>();
        list.add(new BuyProductRequest(1L, 1));
        list.add(new BuyProductRequest(2L, 1));
        list.add(new BuyProductRequest(6L, 1));
        pluginIntegrationService.getResponseDataResponseEntity(user, list);
        // 가입 알람 보내기
        List<Long> users = new ArrayList<>();
        users.add(user.getId());

        restTemplate.postForObject(communicationUrl + "/alarm", new HttpEntity<>(
                AddAlarmRequest.builder()
                    .alarmMessageDTO(AlarmMessageDTO.builder()
                            .kind("인증")
                            .title("환영합니다. 회원가입이 정상 처리되었습니다.")
                            .id(0L)
                            .regDate(LocalDateTime.now())
                            .content("")
                            .build())
                    .users(users)
                    .build()
                , getDefaultHeader())
                , ResponseData.class);

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

    public ResponseEntity<ResponseData> certification(String token) {
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("token", token);
        return restTemplate.postForEntity(userUrl + "/certification", new HttpEntity<>(map, getDefaultHeader(MediaType.MULTIPART_FORM_DATA)), ResponseData.class);
    }
    public ResponseEntity<ResponseData> invite(InviteRequest inviteRequest) {
        UserDTO userDTO = getUser();
        List<Long> users = new ArrayList<>();
        // 사용자 추가
        inviteRequest.getList().stream()
                .forEach(user -> {
                     ResponseData res = restTemplate.postForObject(userUrl + "/signUp/invite"
                             , new HttpEntity<>(new SignUpRequest(user.getUsername()
                                     , user.getPassword()
                                     , user.getName()
                                     , "illunex"
                                     , userDTO.getCompanyIdx())
                                     , getDefaultHeader())
                             , ResponseData.class);
                     UserInfoDTO userDto = UserInfoDTOParser(res);
                     users.add(userDTO.getId());
                     //  인증 메일 보내기
                     restTemplate.postForObject(communicationUrl + "/mail/signUp", new HttpEntity<>(new SignUpMailRequest(user.getUsername(), startUpUrl+"/user/register/confirm?token="+userDto.getToken()), getDefaultHeader()), String.class);
                 }
        );

        // 가입 알람 보내기
        restTemplate.postForObject(communicationUrl + "/alarm", new HttpEntity<>(
                        AddAlarmRequest.builder()
                                .alarmMessageDTO(AlarmMessageDTO.builder()
                                        .kind("인증")
                                        .title("환영합니다. 회원가입이 정상 처리되었습니다.")
                                        .id(0L)
                                        .regDate(LocalDateTime.now())
                                        .content("")
                                        .build())
                                .users(users)
                                .build()
                        , getDefaultHeader())
                , ResponseData.class);

        return ResponseEntity.ok(ResponseData.builder()
                .message("success")
                .errorCode(0)
                .build());
    }
}
