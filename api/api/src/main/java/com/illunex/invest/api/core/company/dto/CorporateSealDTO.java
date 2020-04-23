package com.illunex.invest.api.core.company.dto;

import com.illunex.invest.api.core.user.enumable.SignatureStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CorporateSealDTO {
    Long id;
    String imgUrl;
    SignatureStatus status;
    LocalDateTime updateDate;
    CompanyIdDTO companyIdDTO;
}
