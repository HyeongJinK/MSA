package com.illunex.invest.api.core.company.dto;

import com.illunex.invest.api.core.user.enumable.SignatureStatus;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CorporateSealDTO {
    Long id;
    String imgUrl;
    SignatureStatus status;
    LocalDateTime updateDate;
    CompanyIdDTO companyIdDTO;
}
