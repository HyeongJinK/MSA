package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubsidyDTO {
    Long idx;
    String name;
    String value;
}
