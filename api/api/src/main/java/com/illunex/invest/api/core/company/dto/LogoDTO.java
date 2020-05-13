package com.illunex.invest.api.core.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LogoDTO {
    Long companyIdx;
    String squareLogo;                // 로고
    String rectangleLogo;       // 직사각형 로고
}
