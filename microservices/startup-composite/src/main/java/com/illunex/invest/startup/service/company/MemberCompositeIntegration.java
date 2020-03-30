package com.illunex.invest.startup.service.company;

import com.illunex.invest.api.core.company.dto.MemberDTO;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Log
@Service
public class MemberCompositeIntegration extends DefaultIntegrationService {
    public MemberCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public List<MemberDTO> getMembers() {
        Long companyId = getUser().getCompanyIdx();
        log.info("===========getMembers==================");
        log.info(companyId.toString());
        ResponseEntity<ArrayList> res = restTemplate.getForEntity(companyUrl + "/member/" + companyId.toString(), ArrayList.class);

        return res.getBody();
    }

    public MemberDTO getMember(Long id) {
        return null;
    }

    public void editMember(MemberDTO memberDTO) {
        restTemplate.postForEntity(companyUrl+ "/member"
                , new HttpEntity<>(memberDTO, getDefaultHeader())
                , String.class);
    }

    public void deleteMember(Long id) {
        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
        restTemplate.exchange(userUrl + "/member/"+id
                , HttpMethod.DELETE
                , new HttpEntity<>(map
                        , getDefaultHeader(MediaType.APPLICATION_FORM_URLENCODED))
                , String.class);
    }
}
