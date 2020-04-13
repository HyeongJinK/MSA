package com.illunex.invest.api.core.investment.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditDTO {
    Long companyIdx;
    List<JudgeDTO> judgeList;
    List<ReviewItemTemplateDTO> reviewItemTemplateList;
}
