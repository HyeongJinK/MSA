package com.illunex.invest.api.core.company.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class CompanyWriteCheckDTO {
    String businessRegistrationStatus;
    String CorporateInformationStatus;
}
