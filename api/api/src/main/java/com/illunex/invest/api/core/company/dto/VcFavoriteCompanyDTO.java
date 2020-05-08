package com.illunex.invest.api.core.company.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VcFavoriteCompanyDTO {
    Long idx;
    Long companyIdx;
    Long userIdx;
    LocalDateTime registrationDate;
}
