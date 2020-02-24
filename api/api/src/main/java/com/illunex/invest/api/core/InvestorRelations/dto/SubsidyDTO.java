package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubsidyDTO {
    Long idx;
    String name;
    String value;
}
