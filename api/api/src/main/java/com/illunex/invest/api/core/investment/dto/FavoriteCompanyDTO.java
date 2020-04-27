package com.illunex.invest.api.core.investment.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteCompanyDTO {
    Long idx;
    Long companyIdx;
    Long userIdx;
    LocalDateTime registrationDate;
}
