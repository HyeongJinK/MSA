package com.illunex.invest.startup.service.user;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.user.request.AuthorityRequest;
import com.illunex.invest.startup.service.DefaultCompositeIntegration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AuthCompositeIntegration extends DefaultCompositeIntegration {
    public AuthCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    // TODO 권한 리스트 조회, 권한 수정
    public ResponseEntity<ResponseData> list(Long CompanyIdx) {
        // TODO 회사에서 적용한 플러그인 리스트
        // company + /
        // TODO 플러그인 목록으로 상세한 정보 가져오기

        // TODO 회사 멤버의 권한 목록 가져오기

        // TODO 두개 목록을 조합
        return null;
    }

    public ResponseEntity<ResponseData> edit(AuthorityRequest request) {
        // TODO 권한 수정
        return null;
    }
}
