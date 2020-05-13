package com.illunex.invest.startup.service.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.mypage.dto.AuthorityExDTO;
import com.illunex.invest.api.core.company.dto.PluginDTO;
import com.illunex.invest.api.core.company.dto.enumable.PluginState;
import com.illunex.invest.api.core.user.dto.AuthorityDTO;
import com.illunex.invest.api.core.user.dto.RoleDTO;
import com.illunex.invest.api.core.user.request.AuthorityRequest;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorityIntegrationService extends DefaultIntegrationService {
    public AuthorityIntegrationService(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    // 권한 리스트 조회
    public List<AuthorityExDTO> list() {
        // 회사에서 적용한 플러그인 리스트
        ResponseEntity<ResponseList> pluginsRes = restTemplate.getForEntity(companyUrl + "/plugin/"+ getUser().getCompanyIdx()
                , ResponseList.class);
        List<PluginDTO> plugins =ListDTOParser(pluginsRes.getBody(), PluginDTO.class);
        List<String> ids = plugins.stream()
                .filter(pluginDTO -> pluginDTO.getState().equals(PluginState.OPEN))
                .map(PluginDTO::getPluginId)
                .map(String::valueOf)
                .collect(Collectors.toList());
        // 플러그인 아이디 목록으로 권한 정보 가져오기
        ResponseEntity<ResponseList> roleNamesRes = restTemplate.getForEntity(shopUrl + "/plugin/roleName?ids="+ String.join(",", ids)
                , ResponseList.class);
        List<String> roleNames = roleNamesRes.getBody().getData();

        // 회사 멤버의 권한 목록 가져오기
        ResponseEntity<ResponseList> memberAuthorityRes = restTemplate.getForEntity(userUrl + "/authority/"+ getUser().getCompanyIdx()
                , ResponseList.class);

//        ResponseEntity<List> memberAuthorityRes2 = restTemplate.getForEntity(userUrl + "/authority/list/"+ getUser().getCompanyIdx()
//                , List.class);


        List<AuthorityExDTO> memberAuthority = ListDTOParser(memberAuthorityRes.getBody(), AuthorityExDTO.class);
        System.out.println(memberAuthority);
        System.out.println(memberAuthority.size());
        // 두개 목록을 조합
        return memberAuthority.stream().map(m -> {
            roleNames.stream().forEach(role -> {
                m.getAuthorities().add(new RoleDTO(role));
            });
            return m;
        }).collect(Collectors.toList());
    }

    // 권한 수정
    public ResponseEntity<ResponseData> edit(AuthorityRequest request) {
        // 권한 수정
        return restTemplate.postForEntity(userUrl + "/authority/"
                , new HttpEntity<>(request, getDefaultHeader())
                , ResponseData.class);
    }

    public void getUserList() {
        ResponseEntity<ResponseList> memberAuthorityRes = restTemplate.getForEntity(userUrl + "/authority/"+ getUser().getCompanyIdx()
                , ResponseList.class);

        List<AuthorityExDTO> memberAuthority = memberAuthorityRes.getBody().getData();
        //유저 리스트
    }
    public void getAuthorityList() {
        //유저에 대한 권한
        // 플러그인  권한  읽기 쓰기 수정 삭제

    }
}
