package com.illunex.invest.api.core.main.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WriteCheckDTO {
    String businessRegistrationStatus;
    String CorporateInformationStatus;
    String IRStatus;
}
