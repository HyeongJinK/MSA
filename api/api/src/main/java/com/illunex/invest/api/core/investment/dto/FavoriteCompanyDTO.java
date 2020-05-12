package com.illunex.invest.api.core.investment.dto;

import com.illunex.invest.api.core.company.dto.VcFavoriteCompanyListDTO;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteCompanyDTO {
    VcFavoriteCompanyListDTO vcFavoriteCompanyList;
    List<EvaluateStateDTO> evaluateStateList;
}
