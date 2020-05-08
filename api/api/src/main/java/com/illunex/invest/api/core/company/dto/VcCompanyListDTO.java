package com.illunex.invest.api.core.company.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class VcCompanyListDTO {
    List<VcCompanyDTO> vcCompanyList;
}
