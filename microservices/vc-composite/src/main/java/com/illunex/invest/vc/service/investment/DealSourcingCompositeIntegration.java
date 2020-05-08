package com.illunex.invest.vc.service.investment;

import com.illunex.invest.api.core.company.dto.VcCompanyListDTO;
import com.illunex.invest.api.core.investment.dto.DealSourcingDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateStateListDTO;
import com.illunex.invest.vc.service.DefaultIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class DealSourcingCompositeIntegration extends DefaultIntegrationService {
    Logger logger = LoggerFactory.getLogger(DealSourcingCompositeIntegration.class);

    @Autowired
    WebClient.Builder webClientBuilder;

    public DealSourcingCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    private final String investmentUrl = "http://investment";
    private final String companyUrl = "http://company";

    public DealSourcingDTO getDealSourcingList() {
        WebClient webClient = webClientBuilder.build();

        Mono<VcCompanyListDTO> companyList = webClient
                .get()
                .uri(companyUrl + "/vc/company/list")
                .retrieve()
                .bodyToMono(VcCompanyListDTO.class);

        Mono<EvaluateStateListDTO> evaluateList = webClient
                .get()
                .uri(investmentUrl + "/evaluate/list/state?companyIdx={companyIdx}", getUser().getCompanyIdx())
                .retrieve()
                .bodyToMono(EvaluateStateListDTO.class);

//        companyList.subscribe(s -> {
//
//            evaluateList.subscribe(e -> {
//
//                return DealSourcingDTO.builder()
//                        .companyList(s.getVcCompanyList())
//                        .evaluateStateList(e.getEvaluateState())
//                        .build();
//            });
//
//        });

//        DealSourcingDTO dealSourcingDTO = DealSourcingDTO.builder().build();

        return Mono.zip(companyList, evaluateList).map(t -> DealSourcingDTO.builder()
                .companyList(t.getT1().getVcCompanyList())
                .evaluateStateList(t.getT2().getEvaluateState())
                .build()).block();

//        return (DealSourcingDTO) Mono.zip(companyList, evaluateList).subscribe(t -> {
//                    DealSourcingDTO.builder()
//                    .companyList(t.getT1().getVcCompanyList())
//                    .evaluateStateList(t.getT2().getEvaluateState())
//                    .build();
//        }).block();

//
//            dealSourcingDTO.setCompanyList(t.getT1().getVcCompanyList());
//            dealSourcingDTO.setEvaluateStateList(t.getT2().getEvaluateState());
//            System.out.println("================" + t.getT1().getVcCompanyList().toString());
//            System.out.println("================" + t.getT2().getEvaluateState().toString());

//        });


//        System.out.println("-------------" + dealSourcingDTO.getCompanyList().toString());
//        System.out.println("-------------" + dealSourcingDTO.getCompanyList().size());
//        System.out.println("-------------" + dealSourcingDTO.getEvaluateStateList().toString());
//        System.out.println("-------------" + dealSourcingDTO.getEvaluateStateList().size());
//
//        return dealSourcingDTO;
//
//    public DealSourcingDTO getDealSourcingList() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        VcCompanyListDTO companyList =  restTemplate.getForEntity(companyUrl + "/vc/company/list", VcCompanyListDTO.class).getBody();
//        List<EvaluateStateDTO> evaluateList = restTemplate.getForEntity(investmentUrl + "/evaluate/list/state?companyIdx={companyIdx}", EvaluateStateListDTO.class, getUser().getCompanyIdx()).getBody().getEvaluateState();
//        return DealSourcingDTO.builder()
//                .companyList(companyList.getVcCompanyList())
//                .evaluateStateList(evaluateList)
//                .build();
//    }

    }
}
