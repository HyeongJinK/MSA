package com.illunex.invest.api.core.investment.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VQRoundDTO {
    Long companyIdx;
    String infoUseAgreement;
    String newsAgreement;
    String company;
    String name;
    String contact;
    String email;
    String project;
    String productInfo;
    String features;
    String supportBusiness;
    String supportAgency;
    String businessRegistration;
    String companyProfile;
    String companyProfileLink;
    String businessRegistrationFile;
    String companyProfileFile;
}
