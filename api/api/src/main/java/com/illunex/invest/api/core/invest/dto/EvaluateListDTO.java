package com.illunex.invest.api.core.invest.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateListDTO {
    List<EvaluateDTO> evaluateList;
}
