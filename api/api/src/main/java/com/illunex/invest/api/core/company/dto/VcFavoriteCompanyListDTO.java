package com.illunex.invest.api.core.company.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class VcFavoriteCompanyListDTO {
    List<VcCompanyDTO> vcCompanyList;
    List<VcFavoriteCompanyDTO> vcFavoriteCompanyList;
}
