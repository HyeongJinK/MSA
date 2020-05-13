package com.illunex.invest.vc.service.investment;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateDetailDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateJudgeDTO;
import com.illunex.invest.api.core.investment.dto.JudgeDTO;
import com.illunex.invest.vc.service.DefaultIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvestmentCompositeIntegration extends DefaultIntegrationService {
    Logger logger = LoggerFactory.getLogger(InvestmentCompositeIntegration.class);

    public InvestmentCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    private final String investmentUrl = "http://investment";
    private final String companyUrl = "http://company";

    public EvaluateDetailDTO getEvaluate(Long evaluateIdx) {

        EvaluateDTO evaluateDTO = restTemplate.getForObject(investmentUrl + "/evaluate/detail?evaluateIdx={evaluateIdx}", EvaluateDTO.class, evaluateIdx);
        CompanyDTO companyDTO = restTemplate.getForObject(companyUrl + "/company/read/"+getUser().getCompanyIdx(), CompanyDTO.class);

        List<EvaluateJudgeDTO> evaluateJudgeDTOList = new ArrayList<>();

        for (EvaluateJudgeDTO e: evaluateDTO.getJudgeList()) {
            if (e.getUserIdx().equals(getUser().getId())) {
                evaluateJudgeDTOList.add(e);
            }
        }

        if ( (evaluateDTO.getStatus().equals("waiting")) || (evaluateDTO.getStatus().equals("reject")) ) {
            evaluateDTO.setJudgeList(evaluateJudgeDTOList);
        }

        return EvaluateDetailDTO.builder()
            .evaluate(evaluateDTO)
            .judge(JudgeDTO.builder()
                    .userIdx(getUser().getId())
                    .companyIdx(getUser().getCompanyIdx())
                    .name(getUser().getName())
                    .rank(getUser().getRank())
                    .company(companyDTO.getName())
                    .imgUrl(getUser().getProfileImg())
                    .build())
            .build();
    }

    public String setEvaluate(Long companyIdx) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        CompanyDTO companyDTO = restTemplate.getForObject(companyUrl + "/company/read/"+companyIdx, CompanyDTO.class);

        ProductDTO productDTO = restTemplate.getForObject(companyUrl + "/product/mainProduct/"+companyIdx, ProductDTO.class);

        EvaluateDTO evaluateDTO = EvaluateDTO.builder()
                .company(companyDTO.getName())
                .companyIdx(companyDTO.getCompanyIdx())
                .imgUrl(companyDTO.getLogo().getSquareLogo())
                .product(productDTO.getTitle())
//                .scale(companyDTO.getScale())
                .vcCompanyIdx(getUser().getCompanyIdx())
                .build();

        return restTemplate.postForObject(investmentUrl + "/evaluate/", new HttpEntity(evaluateDTO, headers), String.class);
    }

}
