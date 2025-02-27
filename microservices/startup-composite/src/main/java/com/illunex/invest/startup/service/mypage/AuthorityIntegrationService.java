package com.illunex.invest.startup.service.mypage;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.mypage.dto.AuthorityExDTO;
import com.illunex.invest.api.core.company.dto.PluginDTO;
import com.illunex.invest.api.core.company.dto.enumable.PluginState;
import com.illunex.invest.api.core.shop.dto.PluginRoleDTO;
import com.illunex.invest.api.core.user.dto.AuthRoleDTO;
import com.illunex.invest.api.core.user.dto.RoleDTO;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.request.AuthorityItem;
import com.illunex.invest.api.core.user.request.AuthorityRequest;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorityIntegrationService extends DefaultIntegrationService {
    public AuthorityIntegrationService(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    // 권한 리스트 조회
    public List<AuthorityExDTO> list() {
//        // 회사에서 적용한 플러그인 리스트
//        ResponseEntity<ResponseList> pluginsRes = restTemplate.getForEntity(companyUrl + "/plugin/"+ getUser().getCompanyIdx()
//                , ResponseList.class);
//        List<PluginDTO> plugins =ListDTOParser(pluginsRes.getBody(), PluginDTO.class);
//        List<String> ids = plugins.stream()
//                .filter(pluginDTO -> pluginDTO.getState().equals(PluginState.OPEN))
//                .map(PluginDTO::getPluginId)
//                .map(String::valueOf)
//                .collect(Collectors.toList());
//        // 플러그인 아이디 목록으로 권한 정보 가져오기
//        ResponseEntity<ResponseList> roleNamesRes = restTemplate.getForEntity(shopUrl + "/plugin/roleName?ids="+ String.join(",", ids)
//                , ResponseList.class);
//        List<String> roleNames = roleNamesRes.getBody().getData();
//
//        // 회사 멤버의 권한 목록 가져오기
//        ResponseEntity<ResponseList> memberAuthorityRes = restTemplate.getForEntity(userUrl + "/authority/"+ getUser().getCompanyIdx()
//                , ResponseList.class);
//
////        ResponseEntity<List> memberAuthorityRes2 = restTemplate.getForEntity(userUrl + "/authority/list/"+ getUser().getCompanyIdx()
////                , List.class);
//
//
//        List<AuthorityExDTO> memberAuthority = ListDTOParser(memberAuthorityRes.getBody(), AuthorityExDTO.class);
//        // 두개 목록을 조합
//        return memberAuthority.stream().map(m -> {
//            roleNames.stream().forEach(role -> {
//                m.getAuthorities().add(new RoleDTO(role));
//            });
//            return m;
//        }).collect(Collectors.toList());
        return null;
    }

    // 권한 수정
    public ResponseEntity<ResponseData> edit(AuthorityRequest request) {
        return restTemplate.postForEntity(userUrl + "/authority/"
                , new HttpEntity<>(request, getDefaultHeader())
                , ResponseData.class);
    }

    public List<AuthorityExDTO> getUserList() {
        ResponseEntity<ResponseList> memberAuthorityRes = restTemplate.getForEntity(userUrl + "/authority/"+ getUser().getCompanyIdx()
                , ResponseList.class);

        return memberAuthorityRes.getBody().getData();

    }
    public List<com.illunex.invest.api.core.shop.dto.PluginDTO> getAuthorityList(Long userId) {
        // 회사에서 적용한 상품 리스트
        UserDTO user = getUser();
        ResponseEntity<ResponseList> pluginsRes = restTemplate.getForEntity(companyUrl + "/plugin/"+ user.getCompanyIdx()
                , ResponseList.class);
        List<PluginDTO> plugins =ListDTOParser(pluginsRes.getBody(), PluginDTO.class);
        List<String> ids = plugins.stream()
                .filter(pluginDTO -> pluginDTO.getState().equals(PluginState.OPEN))
                .map(PluginDTO::getProductId)
                .map(String::valueOf)
                .collect(Collectors.toList());
        // 플러그인 아이디 목록으로 권한 정보 가져오기
        ResponseEntity<ResponseList> companyPlugins = restTemplate.getForEntity(shopUrl + "/product/plugins?ids="+ String.join(",", ids)
                , ResponseList.class);

        List<com.illunex.invest.api.core.shop.dto.PluginDTO> auths = ListDTOParser(companyPlugins.getBody(), com.illunex.invest.api.core.shop.dto.PluginDTO.class);

        AuthRoleDTO autoRoleDTO = restTemplate.getForObject(userUrl + "/authority/ir?userIdx=" + userId, AuthRoleDTO.class);

        auths.forEach(auth -> {
            auth.getPluginRole()
                .forEach(pluginRole -> {
                    pluginRole.setId(userId);
                    pluginRole.setId(null);
                    for (RoleDTO role : autoRoleDTO.getAuthorities()) {
                        if (pluginRole.getRoleTitle().equals(role.getName())) {
                            pluginRole.setId(role.getId());
                            pluginRole.setDetailedRights(role.getDetailedRights());
                            break;
                        }
                    }
            });
        });

        //System.out.println(auths);

        return auths;
    }
}
