package com.illunex.invest.api.core.ir.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutcomeDTO {
    Long idx;
    Long irIdx;
    String content;

    List<InvestDTO> invest;             // 투자
    List<AwardDTO> award;               // 수상실적
    List<ExportDTO> export;             // 수출
    List<FundDTO> fund;                 // 정책자금
    List<PlanDTO> plan;                 // 주요계획
}
