package com.illunex.invest.startup.controller.invest;

import com.illunex.invest.api.core.investment.dto.VQRoundDTO;
import com.illunex.invest.startup.service.invest.RoundCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class RoundController {
    Logger logger = LoggerFactory.getLogger(RoundController.class);

    private final RoundCompositeIntegration roundCompositeIntegration;

    @PostMapping(value = "invest/round")
    public ResponseEntity<String> VQRoundAnswer(
        @RequestParam("businessRegistrationFile")MultipartFile businessRegistrationFile,
        @RequestParam("companyProfileFile")MultipartFile companyProfileFile,
        @RequestParam("infoUseAgreement")String infoUseAgreement,
        @RequestParam("newsAgreement")String newsAgreement,
        @RequestParam("company")String company,
        @RequestParam("name")String name,
        @RequestParam("contact")String contact,
        @RequestParam("email")String email,
        @RequestParam("project")String project,
        @RequestParam("productInfo")String productInfo,
        @RequestParam("features")String features,
        @RequestParam("supportBusiness")String supportBusiness,
        @RequestParam("supportAgency")String supportAgency,
        @RequestParam("businessRegistration")String businessRegistration,
        @RequestParam("companyProfile")String companyProfile,
        @RequestParam("companyProfileLink")String companyProfileLink
    ) {
        VQRoundDTO vqRoundDTO = VQRoundDTO.builder()
            .infoUseAgreement(infoUseAgreement)
            .newsAgreement(newsAgreement)
            .company(company)
            .name(name)
            .contact(contact)
            .email(email)
            .project(project)
            .productInfo(productInfo)
            .features(features)
            .supportBusiness(supportBusiness)
            .supportAgency(supportAgency)
            .businessRegistration(businessRegistration)
            .companyProfile(companyProfile)
            .companyProfileLink(companyProfileLink)
            .build();

        return new ResponseEntity<>(roundCompositeIntegration.VQRoundAnswer(vqRoundDTO, businessRegistrationFile, companyProfileFile), HttpStatus.OK);
    }

}