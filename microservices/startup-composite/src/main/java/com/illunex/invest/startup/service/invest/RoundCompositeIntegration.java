package com.illunex.invest.startup.service.invest;

import com.illunex.invest.api.core.investment.dto.VQRoundDTO;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RoundCompositeIntegration extends DefaultIntegrationService {
    Logger logger = LoggerFactory.getLogger(RoundCompositeIntegration.class);

    public RoundCompositeIntegration(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public String VQRoundAnswer(VQRoundDTO vqRoundDTO, MultipartFile businessRegistrationFile, MultipartFile companyProfileFile) {

        System.out.println("============== " + getUser().getName());

        System.out.println("============== company" + vqRoundDTO.getCompany());
        System.out.println("============== company" + vqRoundDTO.getInfoUseAgreement());
        System.out.println("============== company" + vqRoundDTO.getNewsAgreement());


        System.out.println("============== businessRegistrationFile" + businessRegistrationFile.getOriginalFilename());
        System.out.println("============== companyProfileFile" + companyProfileFile.getOriginalFilename());

        System.out.println("============== ");

        return "Success";
    }

//
//    public String imgUpload(MultipartFile file, Long irIdx) {
//        ResponseEntity<ResponseData> uploadRes = fileUpload(file, "invest-startup", "ir/member/");
//        String imgUrl = String.valueOf(uploadRes.getBody().getData());
//
//        ImgDTO imgDTO = ImgDTO.builder()
//                .imgUrl(imgUrl)
//                .irIdx(irIdx)
//                .build();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        restTemplate.postForEntity(irUrl + "/ir/img/temp", new HttpEntity(imgDTO, headers), String.class);
//
//        return imgUrl;
//    }
//
//    public String imgDelete(ImgDTO imgDTO) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        MultiFileDeleteDTO multiFileDeleteDTO = restTemplate.postForObject(irUrl + "/ir/img/delete", new HttpEntity(imgDTO, headers), MultiFileDeleteDTO.class);
//
//        if (multiFileDeleteDTO.getBucket().equals("unavailable")) {
//            return "Temp img does not exist";
//        } else {
//            return multiFileDelete(multiFileDeleteDTO).getBody();
//        }
//    }

}
