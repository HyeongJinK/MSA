package com.illunex.invest.api.core.investment.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateStateDTO {
    Long companyIdx;
    Long vcCompanyIdx;
    LocalDateTime createDate;
    LocalDateTime requestDate;
    LocalDateTime completeDate;
    String scale;
    String status;
}
