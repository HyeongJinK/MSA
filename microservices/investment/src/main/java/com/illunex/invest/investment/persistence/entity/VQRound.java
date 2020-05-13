package com.illunex.invest.investment.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vq_round")
public class VQRound {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    Long companyIdx;
    String roundName;
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
    String companyProfileLink;
    String businessRegistrationFile;
    String companyProfileFile;
}
